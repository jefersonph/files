<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>


<table border="2">
<tr>
<td>
<f:subview id="nested1">
  <tiles:insert attribute="nested1" flush="false" />
</f:subview>
</td>
<td>
<f:subview id="nested2"> 
  <tiles:insert attribute="nested2" flush="false"/>
</f:subview>
</td>
</tr>
</table>