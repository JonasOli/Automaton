package automaton;

import javax.swing.JOptionPane;

/**
 *
 * @author Jonas Oliveira da Silva Filho
 */
public class Automaton {

    int cont;
    static char [] car;
    boolean cadeiaOK;
    
    public static void main(String[] args) {
        Automaton autom = new Automaton();
        
        String cadeia = JOptionPane.showInputDialog(null, "Informe uma cadeia: ");
        car = cadeia.toCharArray();
        autom.inicio();
        
        if(autom.cadeiaOK){
            JOptionPane.showMessageDialog(null, "Cadeia válida!!");
        } else {
            JOptionPane.showMessageDialog(null, "Cadeia invalida!!");
        }
    }
    
    public void inicio(){
        cont = 0;
        cadeiaOK = false;
        q0();
    }
    
    public void q0(){
        System.out.println("Estado q0");
        cadeiaOK = false;
        if(cont<car.length){
            if(car[cont] == '+' || car[cont] == '-'){
                cont++;
                q1();
            } else if(car[cont] == '0' || car[cont] == '1' || car[cont] == '2' || car[cont] == '3' || car[cont] == '4' || car[cont] == '5' || car[cont] == '6' || car[cont] == '7' || car[cont] == '8' || car[cont] == '9'){
                cont++;
                q3();
            } else if(car[cont] == '.'){
                cont++;
                q2();
            } else{
                qErro();
            }
        }
    }
    
    public void q1(){
        System.out.println("Estado q1");
        cadeiaOK = false;
        if(cont<car.length){
            if(car[cont] == '0' || car[cont] == '1' || car[cont] == '2' || car[cont] == '3' || car[cont] == '4' || car[cont] == '5' || car[cont] == '6' || car[cont] == '7' || car[cont] == '8' || car[cont] == '9'){
                cont++;
                q3();
            } else if(car[cont] == '.'){
                cont++;
                q2();
            } else{
                qErro();
            }
        }
    }
    
    public void q2(){
        System.out.println("Estado q2");
        cadeiaOK = false;
        if(cont<car.length){
            if(car[cont] == '0' || car[cont] == '1' || car[cont] == '2' || car[cont] == '3' || car[cont] == '4' || car[cont] == '5' || car[cont] == '6' || car[cont] == '7' || car[cont] == '8' || car[cont] == '9'){
                    cont++;
                    q5();
            } else{
                qErro();
            }
        }
    }
    
    public void q3(){
        System.out.println("Estado final q3");
        cadeiaOK = true;
        if(cont<car.length){
            if(car[cont] == '0' || car[cont] == '1' || car[cont] == '2' || car[cont] == '3' || car[cont] == '4' || car[cont] == '5' || car[cont] == '6' || car[cont] == '7' || car[cont] == '8' || car[cont] == '9'){
                cont++;
                q3();
            } else if(car[cont] == 'E'){
                cont++;
                q6();
            } else if(car[cont] == '.'){
                cont++;
                q4();
            } else {
                qErro();
            }
        }
    }
    
    public void q4(){
        System.out.println("Estado q4");
        cadeiaOK = false;
        if(cont<car.length){
            if(car[cont] == '0' || car[cont] == '1' || car[cont] == '2' || car[cont] == '3' || car[cont] == '4' || car[cont] == '5' || car[cont] == '6' || car[cont] == '7' || car[cont] == '8' || car[cont] == '9'){
                    cont++;
                    q5();
            } else
                qErro();
        }
    }
    
    public void q5(){
        System.out.println("Estado final q5");
        cadeiaOK = true;
        if(cont<car.length){
            if(car[cont] == '0' || car[cont] == '1' || car[cont] == '2' || car[cont] == '3' || car[cont] == '4' || car[cont] == '5' || car[cont] == '6' || car[cont] == '7' || car[cont] == '8' || car[cont] == '9'){
                cont++;
                q5();
            } else if(car[cont] == 'E'){
                cont++;
                q6();
            } else
                qErro();
        }
    }
    
    public void q6(){
        System.out.println("Estado q6");
        cadeiaOK = false;
        if(cont<car.length){
            if(car[cont] == '+' || car[cont] == '-'){
                cont++;
                q8();
            } else if(car[cont] == '0' || car[cont] == '1' || car[cont] == '2' || car[cont] == '3' || car[cont] == '4' || car[cont] == '5' || car[cont] == '6' || car[cont] == '7' || car[cont] == '8' || car[cont] == '9'){
                cont++;
                q9();
            } else {
                qErro();
            }
        }
    }
    
    public void q8(){
        System.out.println("Estado q8");
        cadeiaOK = false;
        if(cont<car.length){
            if(car[cont] == '0' || car[cont] == '1' || car[cont] == '2' || car[cont] == '3' || car[cont] == '4' || car[cont] == '5' || car[cont] == '6' || car[cont] == '7' || car[cont] == '8' || car[cont] == '9'){
                cont++;
                q9();
            } else {
                qErro();
            }
        }
    }
    
    public void q9(){
        System.out.println("Estado final q9");
        cadeiaOK = true;
        if(cont<car.length){
            if(car[cont] == '0' || car[cont] == '1' || car[cont] == '2' || car[cont] == '3' || car[cont] == '4' || car[cont] == '5' || car[cont] == '6' || car[cont] == '7' || car[cont] == '8' || car[cont] == '9'){
                cont++;
                q9();
            } else {
                qErro();
            }
        }
    }
    
    public void qErro(){
        System.out.println("Estado de Erro!!!");
        cadeiaOK = false;
    }
}