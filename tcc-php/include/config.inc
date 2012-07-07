<?php

class Config {

	// Declaracao de Atributos
	var $file;
	var $configArray;

	// Construtor
	function Config ($configFile) {
		$this->file = $configFile;
	}

	// Realiza o parse da configuracao
	function parseConfig($processaSessoes = true){
		$this->configArray = parse_ini_file($this->file, $processaSessoes);
	}

	// Busca um valor do arquivo de configuracao
	function getConfig($sessao, $chave){
		return $this->configArray[$sessao][$chave];
	}
	// Busca um valor do arquivo de configuracao
	function getConfigAll(){
		return $this->configArray;
	}

	// Realiza a checagem da configuracao
	function getConfigNoKey($arq){

		foreach ($this->configArray as $sessao => $chavesSessao){	
			foreach ($chavesSessao as $chave){
				if(StartsWith($arq, $sessao)){
					if (!$this->GetConfig($sessao, $chave)){
						return $sessao;
					}
				}
			}
		}
	}
	// Realiza a checagem da configuracao
	function checkConfig($arrayChecagem){
		foreach ($arrayChecagem as $sessao => $chavesSessao){
			foreach ($chavesSessao as $chave){
				if (!$this->GetConfig($sessao, $chave)){
					return false;
				}
			}
		}
		return true;
	}
}


?>

