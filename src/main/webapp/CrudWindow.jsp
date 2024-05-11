<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMPLOYEE CRUD</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
.form{
	margin: auto 0;
	background-color: yellow;
	width: 50%;
	text-align: center;
	padding: 10%;
	margin: 10% 0 0 25%;
	border-radius: 30px;
}

.b{
	margin: 0 5px;
}
</style>
<body class="container">
	<form method="post" action="crudserve">
	<div class="form">
		<div id="title" class="mb-3">
			<h1>EMPLOYEES</h1>
		</div>
		<div id="formfill">
		
		
		<table>
		<tr>
			<td><a>Emp No </a></td>
			<td><input name="eno" type="text"></td>
		</tr>
		<tr>
			<td><a>Name</a></td>
			<td><input name="ename" type="text"></td>
		</tr>
		<tr>
			<td><a>Job </a></td>
			<td><input name="job" type="text"></td>
		</tr>
		<tr>
			<td><a>Salary </a></td>
			<td><input name="sal" type="number"></td>
		</tr>
		<tr>
			<td><a>Dept No </a></td>
			<td><input name="dept" type="number"></td>
		</tr>
		</table>
		
		
		</div>
		<br />
		<div>
			<input class="btn btn-success b" type="button" value="First" name="firstb" id="firstb"> 
			<input class="btn btn-info b" type="button" value="Prev" name="prevb" id="prevb"> 
			<input class="btn btn-info b" type="button" value="Next" name="nextb" id="nextb">
			<input class="btn btn-success b" type="button" value="Last" name="lastb" id="lastb">
		</div>
		<div class="mt-3">
			<input class="btn btn-success b" type="submit" value="Add" name="action"> 
			<input class="btn btn-secondary b" type="submit" value="Edit" name="action">
			<input class="btn btn-danger b" type="submit" value="Delete" name="action">
		</div>
	</div>
	</form>
	
	<div>
		<table class="table table-striped" id="employeeTable">
			<thead>
			<tr>
				<td>EmpId</td>
				<td>Name</td>
				<td>Job</td>
				<td>Salary</td>
				<td>Dept No</td>
			</tr>
			</thead>
			<tbody>
  			<% ArrayList<Employee> emps = (ArrayList<Employee>)request.getAttribute("empls");
				if(emps!=null){
					for(Employee emp: emps)
					{
				%>
				<tr>
					<td><%=emp.getEmpno() %></td>
					<td><%=emp.getEname() %></td>
					<td><%=emp.getJob() %></td>
					<td><%=emp.getSalary() %></td>
					<td><%=emp.getDept() %></td>
				</tr>
				<%
					}
				} %>
			</tbody>
		</table>
	</div>
	<script>
		document.addEventListener("DOMContentLoaded",function(){
			var index = 1;
			var rowIndex = 1;
			var rows;
			
			var table = document.getElementById("employeeTable");
			var rows = table.getElementsByTagName("tr");
			
			function populateForm(rows,rowIn){
				
				var cells = rows.getElementsByTagName("td");
				document.getElementsByName("eno")[0].value = cells[0].innerHTML;
				document.getElementsByName("ename")[0].value = cells[1].innerHTML;
				document.getElementsByName("job")[0].value = cells[2].innerHTML;
				document.getElementsByName("sal")[0].value = cells[3].innerHTML;
				document.getElementsByName("dept")[0].value = cells[4].innerHTML;
				
				rowIndex=rowIn;
			}
			
			for(var i=0;i<rows.length;i++)
			{
				rows[i].addEventListener("click",function(){
					rowIndex = Array.prototype.indexOf.call(rows,this);
					populateForm(this,rowIndex);
				});
			}
			
			function getNext(){
				if(rowIndex<rows.length-1)
					{
						rowIndex++;
						populateForm(rows[rowIndex],rowIndex);
					}
			}
			
			function getPrev(){
				if(rowIndex>1)
					{
						rowIndex--;
						populateForm(rows[rowIndex],rowIndex);
					}
			}
			
			function getFirstOne()
			{
				populateForm(rows[1],1);
			}
			
			function getLastOne()
			{
				populateForm(rows[rows.length-1],rows.length-1);
			}
			
			document.getElementById("nextb").addEventListener("click",function(){
				getNext();
				console.log("moving next");
			});
			
			document.getElementById("prevb").addEventListener("click",function(){
				getPrev();
				console.log("moving back");
			});
			
			document.getElementById("firstb").addEventListener("click",function(){
				getFirstOne();
			});
			
			document.getElementById("lastb").addEventListener("click",function(){
				getLastOne();
			});
		});
	</script>
</body>
</html>