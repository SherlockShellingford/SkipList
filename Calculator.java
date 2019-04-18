import java.util.LinkedList;
import java.util.List;
import  java.util.Scanner;
public class Calculator {

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("Please select an operation:\n1. Addition\n" +
                    "2. Multiplication\n3. Evaluation\n4. Derivate\n5. Exit");
            int a = reader.nextInt();
            if (a == 5) {
                return;
            }
            System.out.println("Please select the scalar field");
            String s = reader.next();
            System.out.println("enter polynomials");
            String pol = reader.next();
            Polynomial pol1;
            if (s == "Q") {
                pol1 = makePolq(pol);
            } else {
                pol1 = makePolr(pol);
            }
            if (s == "Q") {
                if (a == 1) {
                    String poly = reader.next();
                    Polynomial pol2 = makePolq(poly);
                    System.out.println(pol1.add(pol2));
                }
                else if (a == 2) {
                    String poly = reader.next();
                    Polynomial pol2 = makePolq(poly);
                    System.out.println(pol1.mul(pol2));
                }
                else if (a == 3) {
                    System.out.println("enter a scalar");
                    String scal = reader.next();
                    RationalScalar sc;
                    if (scal.contains("/")) {
                        sc = new RationalScalar(Integer.parseInt(scal.split("/")[0]),
                                Integer.parseInt(scal.split("/")[1]));
                    }
                    else {
                        sc = new RationalScalar(Integer.parseInt(scal), 1);
                    }
                    System.out.println(pol1.evaluate(sc));
                }
                else {
                    System.out.println(pol1.derivate());
                }
            }
            else{
                if (a == 1) {
                    String poly = reader.next();
                    Polynomial pol2 = makePolr(poly);
                    System.out.println(pol1.add(pol2));
                }
                else if (a == 2) {
                    String poly = reader.next();
                    Polynomial pol2 = makePolr(poly);
                    System.out.println(pol1.mul(pol2));
                }
                else if (a == 3) {
                    System.out.println("enter a scalar");
                    String scal = reader.next();
                    RealScalar sc;
                    sc = new RealScalar(Integer.parseInt(scal));
                    System.out.println(pol1.evaluate(sc));
                }
                else {
                    System.out.println(pol1.derivate());
                }
            }
        }
    }

    static public Polynomial makePolq(String pol){
        RationalScalar n = new RationalScalar(0,0);
        LinkedList<PolyTerm> lst = new LinkedList<PolyTerm>();
        int ex = 0;
        String[] s = pol.split("\\+");
        for (String plus:s){
            String[] p = plus.split("-");
            for (int i = 0; i < p.length; i++){
                if (p[i].contains("x")){
                    if (p[i].contains("/")){
                        n = new RationalScalar(Integer.parseInt(p[i].substring(0, p[i].indexOf('/'))),
                                Integer.parseInt(p[i].substring(p[i].indexOf("/"), p[i].indexOf('x'))));
                    }
                    else{
                        n = new RationalScalar(Integer.parseInt(p[i].substring(0, p[i].indexOf('x'))),1);
                    }
                    if (p[i].contains("^")){
                        ex = Integer.parseInt(p[i].substring(p[i].indexOf('^') + 1));
                    }
                    else{
                        ex = 1;
                    }
                }
                else{
                    if (p[i].contains("/")){
                        n = new RationalScalar(Integer.parseInt(p[i].substring(0, p[i].indexOf('/'))),
                                Integer.parseInt(p[i].substring(p[i].indexOf("/"))));
                    }
                    else{
                        n = new RationalScalar(Integer.parseInt(p[i]),1);
                    }
                }
                if (i != 0){
                    n.setValue(n.getNum() * (-1), n.getDen());
                }
                if (pol.indexOf('-') == 0 & plus.equals(s[0]) & i == 0){
                    n.setValue(n.getNum() * (-1), n.getDen());
                }
                lst.add(new PolyTerm(n, ex));
            }
        }
        return new Polynomial(lst);
    }

    static public Polynomial makePolr(String pol){
        RealScalar n = new RealScalar(0);
        LinkedList<PolyTerm> lst = new LinkedList<PolyTerm>();
        int ex = 0;
        String[] s = pol.split("\\+");
        for (String plus:s){
            String[] p = plus.split("-");
            for (int i = 0; i < p.length; i++){
                if (p[i].contains("x")){
                    n = new RealScalar(Double.parseDouble(p[i].substring(0, p[i].indexOf('x'))));
                    if (p[i].contains("^")){
                        ex = Integer.parseInt(p[i].substring(p[i].indexOf('^') + 1));
                    }
                    else{
                        ex = 1;
                    }
                }
                else{
                    n = new RealScalar(Double.parseDouble(p[i]));
                }
                if (i != 0){
                    n.setValue(n.getValue() * (-1));
                }
                if (pol.indexOf('-') == 0 & plus.equals(s[0]) & i == 0){
                    n.setValue(n.getValue() * (-1));
                }
                lst.add(new PolyTerm(n, ex));
            }
        }
        return new Polynomial(lst);
    }
}
