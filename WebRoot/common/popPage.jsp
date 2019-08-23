<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="paging_div">
    <table id="page_tab">
    <tr>
    <td align="right">
    <input id="gopage" name="gopage" style="width:25px" type="text" >
    <input type="button"  class="btn btn-primary btn-sm" value="Go" onclick="gotopage()"/></span>
       </td>
    <td align="left">
       <ul class="pagination" id="pageurl"></ul>
    </td>
    </tr>
    </table>
 </div>
