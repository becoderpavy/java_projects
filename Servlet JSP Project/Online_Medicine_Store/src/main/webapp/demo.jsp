<%@ page import="java.io.*"%>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>


<body>
	<%
	String fName = "c:\\cs\\PaymentSheet.csv";
	String thisLine;
	int count = 0;
	FileInputStream fis = new FileInputStream(fName);
	DataInputStream myInput = new DataInputStream(fis);
	int i = 0;

	while ((thisLine = myInput.readLine()) != null) {
		String strar[] = thisLine.split(",");
	%>
	<table>
		<thead>
			<tr>
				<%
				for (int j = 0; j <=3; j++) {
				%>
				<th><%=strar[0]%></th>
				<%
				}
				}
				%>

			</tr>
		</thead>
		<tbody>
			<!-- <tr>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
			</tr> -->
		</tbody>
	</table>





	<%-- 
				<%
				for (int j = 0; j < strar.length; j++) {

					if (i == 0) {
				%>
				<tr>
					<th><%=strar[j]%></th>
				</tr>
			</thead>
			<%
			} else {
			%>
			<tbody>
				<tr>
					<td><%=strar[j]%></td>

				</tr>
			</tbody>

			<%
			}
			}

			i++;
			}
			%>
		</table> --%>
</body>
</html>