<html>
<body onload="displayUsers()" style="font-family:sans-serif">
<a href="#">Add New</a>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Password</th>
				<th colspan="3">Actions</th>
			</tr>
		</thead>
		<tbody id="userData">
		</tbody>
	</table>
	
	<script type="text/javascript">
		function displayUsers()
		{
			var tableData=document.getElementById("userData").innerHTML;
			var req=new XMLHttpRequest();
			req.open("GET","display",true);
			req.send(null);
			
			req.onreadystatechange=function(){
				if(req.readyState==4 && req.status==200)
					{
						
						var users=JSON.parse(req.responseText);
						console.log(users);
						for(var i=0;i<users.length;i++)
							{
							console.log(users[i]);
							tableData=tableData+"<tr>"+
													"<td>"+users[i].userId+"</td>"+
													"<td>"+users[i].userName+"</td>"+
													"<td>"+users[i].userAddress+"</td>"+
													"<td>"+users[i].userPass+"</td>"+
													"<td><a href='#'>view</a></td>"+
													"<td><a href='#'>Edit</a></td>"+
													"<td><a href='#'>Delete</a></td>"+
												"</tr>";
							}
						document.getElementById("userData").innerHTML=tableData;
					}
			}
		}
	</script>
</body>
</html>
