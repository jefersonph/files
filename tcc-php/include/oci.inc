<?php
/* o putenv esta sendo usado duas vezes */

class Oracle {

	// Declaração de Variavéis
	var $ora_conn, $ora_stmt;
	var $str_query, $num_rows, $num_cols, $rownum;
	var $ora_user, $ora_pass, $ora_tnsname;
	var $err_num, $err_msg;
	var $bind = array();
	var $conneted = false;

	// Função inicial
	function Oracle ($user, $pass, $tnsname) {
		$this->ora_user = $user;
		$this->ora_pass = $pass;
		$this->ora_tnsname = $tnsname;
	}

	// Conecta no banco
	function begin () {
//		if(!$this->connected){			
			putenv(CLIENT);
			putenv(NLS_LANG);
			putenv('NLS_NUMERIC_CHARACTERS=.');
			$this->ora_conn = OciLogon($this->ora_user, $this->ora_pass, $this->ora_tnsname,ORA_LANG);
			if ($this->ora_conn == false) {
				$erro = ocierror();
				$this->erro("OciPLogon", $erro[code], $erro[message]." ($this->ora_tnsname)", 1);
				return 0;
			}
//			$this->connected = true;
//		}
		return $ora_conn;
	}

	// Desconecta do banco
	function ociend () {
		if ($this->ora_conn != false) {
			OCIFreeStatement($this->ora_stmt);
			OCIFreeCursor($this->bind[c1]);
			$this->ora_conn = OciLogoff($this->ora_conn);
		}
//		$this->connected = false;
		return 1;
	}

	// Executa uma stored procedures
	function exec ($arg, $var="") {
		global $$var;
		$this->str_query = $arg;
		if ($var != "") {
			$stmt = OCIParse($this->ora_conn, "BEGIN :$var := $arg; END;");
			//OCIBindByName($stmt, ":$var", &$$var, 10);
			OCIBindByName($stmt, ":$var", $$var, 10);
		} else {
			$stmt = OCIParse($this->ora_conn, "BEGIN $arg; END;");
		}
		OCIExecute($stmt);
		OCIFreeStatement($stmt);
		return $$var;
	}

	function table_to_comma ($query, $col) {
		$this->query($query);
		//while ($this->row(&$row)) {
		while ($this->row($row)) {
			$return .= $row[$col] . ", ";
		}
		return substr($return, 0, -2);
	}

	// Executa query
	function query ($query, $dbg=1) {
		$this->str_query = $query;
		$this->ora_stmt = OciParse($this->ora_conn, $query);
		if ($this->ora_stmt == false) {
			$this->erro("OciParse:".$query, 0, $php_errormsg, 0, $dbg);
			return 0;
		}
		$ora_exec = OciExecute($this->ora_stmt);
		$this->num_rows = OCIRowCount($this->ora_stmt);
		if (!$ora_exec) {
			$this->erro("OciExecute:".$query, 0, OciError(), 0, $dbg);
			return 0;
		}
		$this->num_cols = OCINumCols($this->ora_stmt);
		return 1;
	}

	// Executa query numa procedure
	function query_procedure ($procedure, $dbg=false) {
		if ($dbg){
			print "$procedure\n";
		}
		$this->str_query = "begin $procedure; end;";
		$this->bind[c1] = OCINewCursor($this->ora_conn);
		$this->ora_stmt = OciParse($this->ora_conn, $this->str_query);
		if (eregi(":c1", $procedure)) { OCIBindByName($this->ora_stmt, "c1", $this->bind[c1], -1, OCI_B_CURSOR); }
		if (eregi(":status", $procedure)) { OCIBindByName($this->ora_stmt, "status", $this->bind[status], 255); }
		if (eregi(":n_total", $procedure)) { OCIBindByName($this->ora_stmt, "n_total", $this->bind[n_total], 255); }
		OCIExecute($this->ora_stmt);
		OCIExecute($this->bind[c1]);
		$this->ora_stmt = $this->bind[c1];
		return $this->bind[status];
	}

	// Retorna linha de um query
	function row (&$data) {
		//$result = OCIFetchInto($this->ora_stmt, &$data);
		$result = OCIFetchInto($this->ora_stmt, $data);
		$this->num_rows = OCIRowCount($this->ora_stmt);
		if ($result == false) {
			return 0;
		}
		for ($x = 0; $x < $this->num_cols; $x++) {
			eval("\$data[".strtolower($this->col_name($x))."] = \$data[$x];");
		}
		return $data;
	}

	// Retorna linha de um query com nome da coluna
	function fetch (&$data) {
		//$result = OCIFetchInto($this->ora_stmt, &$data, OCI_ASSOC);
		 $result = OCIFetchInto($this->ora_stmt, $data, OCI_ASSOC);
		$this->num_rows = OCIRowCount($this->ora_stmt);
		if ($result == false) {
			return 0;
		}
		$this->rownum = $this->rownum + 1;
		return $data;
	}

	// Retorna array do query
	function fetch_array ($key="") {
		$ret = array();
		while ($this->fetch($row)) {
			if ($key) {
				$ret[$row[$key]] = $row;
			} else {
				array_push($ret, $row);
			}
		}
		return $ret;
	}

	// Retorna nome da coluna
	function col_name ($col_id) {
		$col_id++;
		return OCIColumnName($this->ora_stmt, $col_id);
	}

	// Retorna tamanho da coluna
	function col_size ($col_id) {
		$col_id++;
		return OCIColumnSize($this->ora_stmt, $col_id);
	}

	// Retorna tipo da coluna
	function col_type ($col_id) {
		$col_id++;
		return OCIColumnType($this->ora_stmt, $col_id);
	}

	// Executa e seta valores do commit
	function commit ($act = "") {
		switch ($act) {
			case 1 :
			case 'on' : {
				OCICommit($this->ora_conn);
				break;
			}
			case 0 :
			case 'off' : {
				OCICommit($this->ora_conn);
				break;
			}
			default : {
				OCICommit($this->ora_conn);
				break;
			}
		}
	}

	// Executa um rollback
	function rollback () {
		$ora_roll = OCIRollback($this->ora_conn);
		if ($ora_roll == false) {
			$this->erro("OCIRollback", 0, OciError());
			return 0;
		}
		return 1;
	}

	// Formata uma data do oracle
	function fdate ($arg, $fmt="d/m/Y h:i") {
		return date($fmt, $this->mkdate($arg));
	}
	function mkdate ($arg, $dbg=0) {
		if (strlen($arg) != 19) { return ""; }
		$date[dia]  = substr($arg,  0, 2);
		$date[mes]  = substr($arg,  3, 2);
		$date[ano]  = substr($arg,  6, 4);
		$date[hora] = substr($arg,  11, 2);
		$date[min]  = substr($arg, 14, 2);
		$date[seg]  = substr($arg, 17, 2);
		if ($dbg == 1) { print("arg: $arg<br>"); print_r($date); }
		return mktime ($date[hora], $date[min], $date[seg], $date[mes], $date[dia], $date[ano]);
	}

	// Mensagem de erro
	function erro ($function, $num, $msg, $exit = 0, $dbg = 1) {
		$this->err_num = $num;
		$this->err_msg = $msg;
		if ($dbg) { 
			echo '[<b>ERRO</b>] <u>$function</u>: '.$num.' - '.$msg.'<br>\n'; 
		}
		my_syslog(LOG_ERR, __FILE__, __line__, $msg.' Function - '.$function);
		if ($exit) { exit; }
	}

}


?>
