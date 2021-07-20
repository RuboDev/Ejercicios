<html>
    <body>
        <h1 style="text-align:center">
            Ejemplo declaraciones
        </h1>

        <%!
        private int resultado;

        public int metodoSuma(int num1, int num2){
            resultado = num1 + num2;
            return resultado;
        }
        
        public int metodoResta(int num1, int num2){
            resultado = num1 - num2;
            return resultado;
        }
        
        public int metodoMultiplica(int num1, int num2){
            resultado = num1 * num2;
            return resultado;
        }
        %>

        7+5 es: <%= metodoSuma(7,5)%>
        <br>

        7-5 es: <%= metodoResta(7,5)%>
        <br>

        7*5 es: <%= metodoMultiplica(7,5)%>
        <br>
    </body>
</html>
