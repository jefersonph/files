<?php
// The file test.xml contains an XML document with a root element
// and at least an element /[root]/title.

if (file_exists('terra.xml')) {
    $xml = simplexml_load_file('terra.xml');
	foreach ($xml->children() as $child)
	{
		echo "Conteudo..: " . $child . "<br />";
	}
} else {
    exit('Failed to open terra.xml.');
}
?>
