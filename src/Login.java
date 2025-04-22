class Login{ 
    private static Login instancia;

    private String usuario; //atributos para usuario e senha
    private String senha;

    private Login(){};  //construtor que impede que outra classe crie objetos login diretamente

    public static Login getInstancia(){ //metodo que retorna a unica instancia da classe
        if(instancia == null){
            instancia = new Login(); //cria a instancia login se ainda não existir
        }
        return instancia;
    }

    public void setCredencial(String usuario, String senha){
        this.usuario = usuario; 
        this.senha = senha;
    }

    public boolean autenticar(String usuario, String senha, String captchaGerado, String captchaDigitado){ //metodo de autenticação de login e captcha
        if(this.usuario.equals(usuario) && this.senha.equals(senha)){ //autenticação de login
            if(captchaDigitado.equals(captchaGerado)){ //autenticação de captcha digitado comparado ao capctha gerado
                System.out.println("Captcha correto!");
                return true;
            }
            return false;
        }
        else{ //verifica se usuario ou senha estão incorretos
            System.out.println("Usuário ou senha estão incorretos!");
            return false;
        }
    }
}
