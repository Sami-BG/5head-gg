<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>5Head.gg</title>
  <meta name="description" content="5Head.gg">

  <link rel="stylesheet" href="/css/patchnotes.css">

</head>

<body>

    <div id="sidebar">
        <div id="logo">

        </div>

        <div class="left-aligned" id="reputation">
            ${userReputation}
            <p style="color:#84929B;">REPUTATION</p>

        </div>

        <div class="left-aligned" id="buttons">
            <a class="sidebarlink" href="/currpatch"> <p style="font-weight: bold; color: #FEFEFE">Current Patch</p></a>

            <a class="sidebarlink" href="/mybets">Profile</a>

            <a class="sidebarlink" href="/leaderboard">Leaderboards</a>
        </div>

        <div id="bettingstatus">
            ${bettingStatus}
        </div>
        
        <div id="profile">
            ${profileImage}
            ${profileName}
            <a href="profile"></a>
        </div>
		
		<div id="logout">
		<form action="/" method="post">
		<button type="submit">Logout</button>
		</form>
		</div>
    </div>
    <div id="canvas">
	${success}
       <form method="POST" action="/mybets/success">
    <label for="rep" style="font-family: georgia">
    Enter your bet here:
    </label><br>
	  <p style="font-family: georgia"> <b>Amount of reputation:</b></p>
<input type="number" id="rep" name="rep"
       step="100" value="0">
	   
	   <b>Champion:</b>
	   <select class="dropbtn" name="champion" value="Aatrox">
  <div class="dropdown-content">
    ${champOptions}
	</select>
  </div>
  <b>Statistic of bet:</b>
    <select class="dropbtn" name="betType" value="pick">
  <div class="dropdown-content">
    <option value="pick">Pick rate</option>
    <option value="ban">Ban rate</option>
	<option value="win">Win rate</option>
	</select>
  </div>
  <p style="font-family: georgia"> <b>New percentage</b></p>
	<input id="percentage" name="percentage" type="number" value="0" step="0.1">
    <input type="submit" alt="Submit">
    </form>
	${myBets}
    </div>
</body>
</html>