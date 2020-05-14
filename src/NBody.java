import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class NBody {
    public static double readRadius(String filename){
        //read the radius of my universe from the file
        try {
            File my_file = new File(filename);
            FileReader fileReader = new FileReader(my_file);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            line = reader.readLine();
            line = reader.readLine();
            reader.close();

            return Double.parseDouble(line);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public static Body[] readBodies(String filename){
          //read all planets from the file
        In file = new In(filename);
        int n = file.readInt();
        Body[] b = new Body[n];
        double temp = file.readDouble();
        for (int i=0;i<n;i++){
            b[i] = new Body(file.readDouble(),file.readDouble(),file.readDouble(),file.readDouble(),file.readDouble(),file.readString());
        }
        return b;
    }
    public static void drawOnce(double radius,Body[] bodies){
        //draw the picture and all bodies;
        String imageToDraw = "images/starfield.jpg";
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, imageToDraw);
        for (Body body : bodies) {
            body.draw();
        }
        StdDraw.show();
    }

    public static void main(String[] args) {
         //load all things i need
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Body[] bodies =  readBodies(filename);
        double radius = readRadius(filename);
        //drawOnce
        drawOnce(radius,bodies);
        //main draw
        double time;
        double[] xForces = new double[bodies.length];
        double[] yForces = new double[bodies.length];
        for (time=0.0;time<=T;time+=dt){
            for (int i=0;i<bodies.length;i++){
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            for (int i=0;i<bodies.length;i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }
            drawOnce(radius, bodies);
            StdDraw.pause(10);
        }
        
    }

}
