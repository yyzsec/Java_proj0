import com.sun.org.apache.bcel.internal.classfile.Constant;
import jdk.internal.dynalink.beans.StaticClass;

public class Body {
    public static final double G = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Body(double xP, double yP, double xV,double yV, double m, String img){
        // initialize an instance of the Body class.
        // Later on, an instance of the Body class can represent a planet,
        // star, or various objects in this universe
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    public Body(Body b){    // initialize an identical Body object (i.e. a copy)//Code reload!
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }
    public double calcDistance(Body a){ //calculate distance between two objects
        return Math.sqrt(Math.pow((this.xxPos-a.xxPos),2)+Math.pow((this.yyPos-a.yyPos),2));
    }
    public double calcForceExertedBy(Body a){  //calculate F between two objects
        return (G*this.mass*a.mass)/ Math.pow(this.calcDistance(a),2);
    }
    public double calcForceExertedByX(Body a){  //calculate Fx between two objects Watch out the sign!!
        if ((this.xxPos-a.xxPos)>0){
            return (this.calcForceExertedBy(a) * (this.xxPos-a.xxPos))/this.calcDistance(a);
        } else {
            return -((this.calcForceExertedBy(a) * (this.xxPos-a.xxPos))/this.calcDistance(a));
        }

    }
    public double calcForceExertedByY(Body a){  //calculate Fy between two objects Watch out the sign!!
        if ((this.yyPos-a.yyPos)>0){
            return (this.calcForceExertedBy(a) * (this.yyPos-a.yyPos))/this.calcDistance(a);
        } else {
            return -((this.calcForceExertedBy(a) * (this.yyPos-a.yyPos))/this.calcDistance(a));
        }

    }
    public double calcNetForceExertedByX(Body[] a){
        double sum=0.0;
        int i;
        for (i = 0;i<a.length;i++){
            if (!this.equals(a[i])){
                if ((this.xxPos - a[i].xxPos)<=0){
                    sum = sum - this.calcForceExertedByX(a[i]);
                } else {
                    sum = sum + this.calcForceExertedByX(a[i]);
                }
            }
        }
        if (sum<0){
            return -sum;
        } else {
            return sum;
        }
    }
    public double calcNetForceExertedByY(Body[] a){
        double sum=0.0;
        int i;
        for (i = 0;i<a.length;i++){
            if (!this.equals(a[i])){
                if ((this.yyPos - a[i].yyPos)<=0){
                    sum = sum - this.calcForceExertedByY(a[i]);
                } else {
                    sum = sum + this.calcForceExertedByY(a[i]);
                }
            }
        }
        if (sum<0){
            return -sum;
        } else {
            return sum;
        }
    }
    public void update(double t,double Nx,double Ny){
        double ax = Nx/this.mass;
        double ay = Ny/this.mass;
        this.xxVel = this.xxVel + t * ax;
        this.yyVel = this.yyVel + t * ay;
        this.xxPos = this.xxPos + t * this.xxVel;
        this.yyPos = this.yyPos + t * this.yyVel;
    }
    public void draw(){
        StdDraw.enableDoubleBuffering();
        //StdDraw.clear();
        StdDraw.picture(this.xxPos,this.yyPos,"images/" + this.imgFileName);
        StdDraw.show();
    }



}
