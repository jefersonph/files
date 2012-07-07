<?php


print_r(svn_repos_create('/home/jeferson/repositorios/empresa4/'));
print_r(svn_checkout('http://www.example.com/svnroot/calc/trunk', dirname(__FILE__) . '/calc'));
print_r(svn_add(''));
print_r(svn_commit('Log message of Bob\'s commit', array(realpath('servidor..'))));
print_r(svn_update(realpath('working-copy'));

/*

Servidor
criar com svn
fazer checkout no repositorios dentro da empresa


servico
criar diretorio no repositorios
svn add no diretorio

criar arquivo
criar arquivo no repositorios do servico
svn add no arquivo


commitar servidor

*/
?>

