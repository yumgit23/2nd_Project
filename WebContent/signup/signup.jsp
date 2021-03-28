<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!-- <!DOCTYPE html> -->
<script src='../js/signup.js'></script>
<link href="../css/signup.css" rel="stylesheet" type="text/css" media="all" />  

  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SIGN UP</title>
        <link rel="stylesheet" href="../css/signup.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>

    </head>
    <body>

      <form action="../main/main.do?m=signup" method="post">
      	<br>
        <h1>SIGN UP</h1>
        <p style="text-align:center">회원가입 페이지입니다.</p>
        <br>
		<br>
		<br>
		<br>
		
        <fieldset>
          
           <label for="ct_id">ID:</label>
          <input type="text" id="ct_id" name="ct_id">
          
          <label for="password">Password:</label>
          <input type="password" id="password" name="ct_pw">
          
          <label for="name">Name:</label>
          <input type="text" id="name" name="ct_name">
          
          <label for="address">Address:</label>
          <input type="text" id="address" name="ct_address">
          
           <label for="phone">Phone:</label>
          <input type="tel" id="phone" name="ct_phone">
          
          <label>Gender:</label>
          <input type="radio" id="female" value="Female" name="ct_gender"><label for="female" class="light">여성</label><br>
          <input type="radio" id="male" value="Male" name="ct_gender"><label for="male" class="light">남성</label><br>
          <br>
          <label for="mail">Email:</label>
          <input type="email" id="mail" name="ct_email">
          
          <label for="birth">Birth:</label>
          <input type="date" id="birth" name="ct_birth">           
         
        </fieldset>
        <button type="submit">SIGN UP</button>
      </form>
      
    </body>
</html>