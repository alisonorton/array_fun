import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ArrayFun extends JPanel {
    //Set array
    int[][] coordinates = new int[200][200];
    int x;
    int y;

	public ArrayFun() {
        //Read file
        String filename = "smiley.txt";
		File f = new File(filename);

        try{
            Scanner s = new Scanner(f);
            while (s.hasNext() == true){
                x = s.nextInt();
                y = s.nextInt();

                coordinates[x][y] = 1;

                //Draw cross
                for (int i = 1; i < 4; i++){
                    coordinates[x][y + i] = 1;
                }
                for (int i = 1; i < 4; i++){
                    coordinates[x][y - i] = 1;
                }
                for (int i = 1; i < 4; i++){
                    coordinates[x + i][y] = 1;
                }
                for (int i = 1; i < 4; i++){
                    coordinates[x - i][y] = 1;
                }

                

                //Draw diaginal
                for (int i = 1; i < 4; i++){
                    coordinates[x - i][y - i] = 1;
                }
                for (int i = 1; i < 4; i++){
                    coordinates[x - i][y + i] = 1;
                }
                for (int i = 1; i < 4; i++){
                    coordinates[x + i][y - i] = 1;
                }
                for (int i = 1; i < 4; i++){
                    coordinates[x + i][y + i] = 1;
                }
                


            }
            s.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not find " + filename);
        }
	}

	@Override
	public void paintComponent(Graphics g) {
        //Draw pixles
        for(int i = 0; i < coordinates.length; i++){
            for(int j = 0; j < coordinates.length; j++){
                if(coordinates[i][j] == 0){
                    g.setColor(Color.BLACK);
                    g.drawRect(i, j, 1, 1);
                }
                else if (coordinates[i][j] == 1){
                    g.setColor(Color.WHITE);
                    g.drawRect(i, j, 1, 1);
                }

            }
        }
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setContentPane(new ArrayFun());
		window.setVisible(true);
	}
}