<?php

require 'include/Smarty/Smarty.class.php';
session_start();

if(!isset($_SESSION["login"])){
	echo' <script type="text/javascript" language="javascript">
			window.location.assign("login.php");
		  </script>
	';
}

$smarty = new Smarty;
$smarty->compile_check = true;
$smarty->debugging = true;
$smarty->assign('cust_checkboxes', array(
			1000 => 'Joe Schmoe',
			1001 => 'Jack Smith',
			1002 => 'Jane Johnson',
			1003 => 'Charlie Brown'));
$smarty->assign('customer_id', 1001);
$smarty->assign('tr',array('bgcolor="#eeeeee"','bgcolor="#dddddd"'));
$smarty->assign("Name","Fred Irving Johnathan Bradley Peppergill");
$smarty->assign("FirstName",array("John","Mary","James","Henry"));
$smarty->assign("LastName",array("Doe","Smith","Johnson","Case"));
$smarty->assign("Class",array(array("A","B","C","D"), array("E", "F", "G", "H"),
	  array("I", "J", "K", "L"), array("M", "N", "O", "P")));
$smarty->assign("contacts", array(array("phone" => "1", "fax" => "2", "cell" => "3"),
	  array("phone" => "555-4444", "fax" => "555-3333", "cell" => "760-1234")));
$smarty->assign("option_values", array("NY","NE","KS","IA","OK","TX"));
$smarty->assign("option_selected", "NE");

switch ($_GET['op']) {
    case index:
        $smarty->display('index.tpl');
        break;
    case servidor:
        $smarty->display('servidor.tpl');
        break;
    case usuario:
        $smarty->display('usuario.tpl');
        break;
	case empresa:
        $smarty->display('empresa.tpl');
        break;
	case servico:
        $smarty->display('servico.tpl');
        break;
	case arquivo:
        $smarty->display('arquivo.tpl');
        break;
	case c_servico:
        $smarty->display('criar_servico.tpl');
        break;
	case c_servidor:
        $smarty->display('criar_servidor.tpl');
        break;
	case c_usuario:
		$smarty->display('criar_usuario.tpl');
        break;
	case c_empresa:
        $smarty->display('criar_empresa.tpl');
        break;
	case c_arquivo:
        $smarty->display('criar_arquivo.tpl');
        break;
	default:
		$smarty->display('index.tpl');
}
?>
