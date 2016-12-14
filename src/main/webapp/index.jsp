<html>
<head>
    <script type="application/javascript">

        console.info(throwTest());

        function throwTest(){
            aa:try{
                if(true){
                    for(;;){
                        break aa;
                    }
                }
            }catch(e) {
                console.info(e);
                console.info("error cathed");
            }finally {
                console.info("finally!");
                return 1;
            }
        }

        /*var i = 5;
        while(i > 3){
            debugger;
            break;
            console.info(i);
            i--;
        }*/


    </script>
</head>
<body>
<h2>Hello World!</h2>
</body>
</html>
