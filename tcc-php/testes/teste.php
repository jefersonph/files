<?php
exec("/usr/sbin/lighttpd -t -f /etc/lighttpd/lighttpd.conf1", $retval);
var_dump($retval);
?>
