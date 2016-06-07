# ShoobaDoobaTalks 
-----DEV LOG----- 
5/12/16 

-Begin socket research, benefits of socket VS. URLConnect 

-Use sockets to connect to programs, and pass a message 

-Read code of sample IRC client 

-Are sockets read/write or just write?

5/13/16 - 5/20/16

-Figure out how sockets and networking work

-Test sample code for sockets and try to figure out how to connect to external IPs

5/16/16

-Make connection over url and not just localhost

-Allow clients to choose their own ports 

5/22/16

-Check if URL is hosting a client 

-check if ports that clients chose are not blocked or not currently in use 

-what the hell is URLConnect  

5/23/16

-Attempted to use GUI on external IP address

-Reverted to localhost version

5/26/16

-Worked further to use external IP address

5/27/16

-Make changes so that the user can change the port the server is hosted on

5/29/16

-Further worked on giving the user the ability to change the port

-Debug work

5/30/16

-Tested more with changing how the server is hosted

5/31/16

-Made final changes to how user can change port and is now functional

6/3/16

-Created method that allows user to find open ports

6/6/16

-Made network connection work

-Polished things up

-Allow private chats

-Allow file transfer


-----PROJECT GOALS----- 
-Functional connection 
-Message transfer 
-If all goes well, file transfer over secure connection 

-----DEMO VERSIONS-----
May 23rd: https://github.com/sunnysompalli/ShoobaDoobaTalksDemo
    -Works on single device at the moment
    -To run, open up terminal and run ShoobaServer.java. Then, open however many terminals based on the number of chatters you want.