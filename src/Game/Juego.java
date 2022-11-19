package Game;

import Cola.colaLista;
import static Game.USER.ptr;
import Pila.PilaLista;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JOptionPane;

/**
 *
 * @author Oneiber Q
 */
public class Juego {

    //usuario que esta jugando
    USER u = new USER();
    // private String nombre = u.getNombre();
    // private String apellido = u.getApellido();
    String usuario = u.getUsuario();
    // private String contraseña = u.getContraseña();
    String Score = u.getScore();

    //
    JFrame ventana;
    JPanel panelJuego;
    JLabel fondo;
    JLabel posicion;
    JLabel tibu;

    //Tiburon
    Rectangle tib;

    //serpiente
    ArrayList<JLabel> serpiente;
    int x;
    int y;
    int ty, tx = 600, ftibu;
    int desplazamiento = 20;
    Timer tiempo;
    int ban = 0;
    Rectangle serp;
    int perdio = 0;
    //muro
    ArrayList<JLabel> muro;
    Rectangle La;

    //comida
    JLabel comida;
    int cx = 0;
    int cy = 0;
    Rectangle comi;
    //puntuacion
    JLabel puntuacion;
    int contador = 0;
    //tiempo
    JLabel time;
    int minutos = 1;
    int segundos = 0;
    int counter = 0;
    //movimiento
    boolean restH = true;
    boolean restV = true;
    //tamaño de la serpiente
    int tamaño;
    Rectangle pos;
    //pause
    boolean pause = false;
    JLabel iconplay;
    JLabel iconpause;

    public Juego() {
        System.out.println("**************");
        System.out.println("score " + Score);
        //ventana
        ventana = new JFrame("Juego de la Serpiente");
        ventana.setSize(595, 595);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);

        //panel
        panelJuego = new JPanel();
        //panelJuego.setSize(ventana.getSize());
        panelJuego.setSize(595, 595);
        panelJuego.setLayout(null);
        panelJuego.setVisible(true);
        //panelJuego.setBackground(Color.red);

        //fondo
        fondo = new JLabel();
        fondo.setSize(panelJuego.getSize());
        fondo.setIcon(new ImageIcon("imagenes/fondo.jpg"));
        fondo.setVisible(true);
        panelJuego.add(fondo, 0);

        //serpiente
        serpiente = new ArrayList<JLabel>();
        JLabel aux = new JLabel();
        aux.setLocation(290, 290);
        aux.setSize(20, 20);
        aux.setIcon(new ImageIcon("imagenes/2.png"));
        aux.setVisible(true);
        serpiente.add(aux);
        panelJuego.add(serpiente.get(0), 0);

        ventana.add(panelJuego);

        //tiburon
        tibu = new JLabel();
        tibu.setSize(80, 80);
        tibu.setIcon(new ImageIcon("imagenes/tiburon2.png"));
        Random alTibu = new Random();
        Random finalTibu = new Random();
        ty = alTibu.nextInt(500);
        ftibu = finalTibu.nextInt(600);
        tibu.setLocation(tx, ty);
        tibu.setVisible(true);
        panelJuego.add(tibu, 0);

        //comida
        comida = new JLabel();
        comida.setSize(20, 20);
        comida.setIcon(new ImageIcon("imagenes/6.png"));
        tamaño = 0;
        //Random aleatorio = new Random();
        cx = (int) (Math.random() * 520) + 31;
        cy = (int) (Math.random() * 460) + 71;
        comida.setLocation(cx, cy);
        comida.setVisible(true);
        panelJuego.add(comida, 0);
        //pause
        iconplay = new JLabel();
        iconpause = new JLabel();
        iconplay.setSize(32, 32);
        iconpause.setSize(32, 32);
        iconplay.setIcon(new ImageIcon("imagenes/play.png"));
        iconpause.setIcon(new ImageIcon("imagenes/pause.png"));
        iconplay.setLocation(540, 5);
        iconpause.setLocation(540, 5);
        iconplay.setVisible(false);
        iconpause.setVisible(true);
        panelJuego.add(iconplay, 0);
        panelJuego.add(iconpause, 0);
        //muro
        int position = 0;
        muro = new ArrayList<JLabel>();
        for (int i = 0; i < 19; i++) {
            JLabel Ladrillo = new JLabel();
            Ladrillo.setLocation(position, 40);
            Ladrillo.setSize(31, 31);
            Ladrillo.setIcon(new ImageIcon("imagenes/muro.jpg"));
            Ladrillo.setVisible(true);
            muro.add(Ladrillo);
            position += 31;
            panelJuego.add(muro.get(muro.size() - 1), 0);
        }

        position = 0;
        for (int i = 0; i < 19; i++) {
            JLabel Ladrillo = new JLabel();
            Ladrillo.setLocation(position, 536);
            Ladrillo.setSize(31, 31);
            Ladrillo.setIcon(new ImageIcon("imagenes/muro.jpg"));
            Ladrillo.setVisible(true);
            muro.add(Ladrillo);
            position += 31;
            panelJuego.add(muro.get(muro.size() - 1), 0);
        }
        position = 40;
        for (int i = 0; i < 17; i++) {
            JLabel Ladrillo = new JLabel();
            Ladrillo.setLocation(0, position);
            Ladrillo.setSize(31, 31);
            Ladrillo.setIcon(new ImageIcon("imagenes/muro.jpg"));
            Ladrillo.setVisible(true);
            muro.add(Ladrillo);
            position += 31;
            panelJuego.add(muro.get(muro.size() - 1), 0);
        }

        position = 40;
        for (int i = 0; i < 17; i++) {
            JLabel Ladrillo = new JLabel();
            Ladrillo.setLocation(558, position);
            Ladrillo.setSize(31, 31);
            Ladrillo.setIcon(new ImageIcon("imagenes/muro.jpg"));
            Ladrillo.setVisible(true);
            muro.add(Ladrillo);
            position += 31;
            panelJuego.add(muro.get(muro.size() - 1), 0);
        }

        ventana.add(panelJuego);

        ////////////
        serp = new Rectangle(serpiente.get(0).getBounds());
        comi = new Rectangle(comida.getBounds());
        pos = new Rectangle(serpiente.get(0).getBounds());
        La = new Rectangle(muro.get(0).getBounds());
        tib = new Rectangle(tibu.getBounds());

        //puntuacion
        puntuacion = new JLabel("SCORE: " + contador);
        puntuacion.setBounds(10, 20, 1000, 20);
        puntuacion.setVisible(true);
        puntuacion.setForeground(Color.black);
        panelJuego.add(puntuacion, 0);

        //tiempo
        time = new JLabel("Tiempo: " + minutos + ":" + segundos);
        time.setBounds(400, 20, 100, 20);
        time.setVisible(true);
        time.setForeground(Color.black);
        panelJuego.add(time, 0);
        //
        boolean word2 = false;
        tiempo = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                comi.setBounds(comida.getBounds());
                serp.setBounds(serpiente.get(0).getBounds());
                tib.setBounds(tibu.getBounds());
                counter++;
                if (counter == 10) {
                    counter = 0;
                    segundos++;
                }
                if (segundos == 60) {
                    segundos = 0;
                    minutos++;
                }

//------------------------------AQUI EMPIEZA NIVEL 2--------------------------------------------
                if (minutos == 1 && minutos <= 2) {

                    for (int i = 0; i < muro.size(); i++) {
                        muro.get(i).setIcon(new ImageIcon("imagenes/planta.png"));
                    }

                    fondo.setIcon(new ImageIcon("imagenes/fondo2.jpg"));
                    fondo.setVisible(true);
                    tibu.setLocation(tx, ty);
                    tx = tx - 20;
                    if (tx < -ftibu) {
                        tx = 600;
                        ty = alTibu.nextInt(500);
                        ftibu = finalTibu.nextInt(600);
                    }

                } else {
                    tibu.setLocation(600, 600);
                }
                while (tib.intersects(comi)) {
                    cx = (int) (Math.random() * 520) + 31;
                    cy = (int) (Math.random() * 460) + 71;
                    comida.setLocation(cx, cy);
                    comi = new Rectangle(comida.getBounds());
                    comida.repaint();
                }

//-----------------------------------HASTA ACA VA SEGUNDO NIVEL-------------------------------------                
                time.setText("Tiempo: " + minutos + ":" + segundos);
                time.repaint();
                //colision con los muros
                if (serpiente.get(0).getX() > 530) {
                    perdio = 1;
                }
                if (serpiente.get(0).getX() < 30) {
                    perdio = 1;
                }
                if (serpiente.get(0).getY() > 510) {
                    perdio = 1;
                }
                if (serpiente.get(0).getY() < 70) {
                    perdio = 1;
                }
                if (perdio == 1) {
                    System.out.println(Score);
                    if (contador > Integer.parseInt(Score.trim())) {
                        try {
                            System.out.println("Hay que actualizar");
                            Actualizar();
                        } catch (IOException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (JOptionPane.showConfirmDialog(null, "Reintentar") == 0) {
                        ventana.setVisible(false);
                        Juego j = new Juego();
                        j.getClass();

                    } else {
                        ventana.setVisible(false);
                        USER u = new USER();
                        u.setVisible(true);

                    }
                    tiempo.stop();

                }
                //colision con ella misma

                for (int i = 1; i <= tamaño; i++) {
                    pos.setBounds(serpiente.get(i).getBounds());

                    if (pos.intersects(serp)) {
                        System.out.println("pierde");

                        if (contador > Integer.parseInt(Score)) {
                            System.out.println("Hay que actualizar");
                            try {
                                Actualizar();
                            } catch (IOException ex) {
                                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        tiempo.stop();
                        if (JOptionPane.showConfirmDialog(null, "Reintentar") == 0) {
                            ventana.setVisible(false);
                            Juego j = new Juego();
                            j.getClass();
                        } else {
                            USER u = new USER();
                            u.setVisible(true);
                            ventana.setVisible(false);
                        }
                    }
//                    if (tib.intersects(pos)) {
//                        
//                    for (int j = serpiente.size()-1; j <= i; i--) {
//                        serpiente.remove(j);
//                    }
//                    }

                    if (serpiente.get(0).getBounds().intersects(tib)) {
                        perdio = 1;
                    } else {

                    }

                }
                //colicion tiburon
                for (int i = 0; i < tamaño; i++) {
                    if (serpiente.get(i).getBounds().intersects(tib)) {
                        serpiente.get(serpiente.size()-1).setIcon(null);
                        serpiente.remove(serpiente.size() - 1);
                        tamaño--;
                    }
                }

                //colision con la comida
                if (comi.intersects(serp)) {
                    cx = (int) (Math.random() * 520) + 31;
                    cy = (int) (Math.random() * 460) + 71;
                    comida.setLocation(cx, cy);
                    comida.repaint();
                    tamaño++;

                    System.out.println("comi");
                    JLabel aux = new JLabel();
                    //  aux.setLocation(200, 200);
                    aux.setSize(20, 20);
                    aux.setIcon(new ImageIcon("imagenes/1.png"));
                    aux.setVisible(true);
                    serpiente.add(aux);
                    panelJuego.add(serpiente.get(serpiente.size() - 1), 0);
                    System.out.println("" + serpiente.size());
                    contador += 5;
                    //desplazamiento++;
                    puntuacion.setText("SCORE: " + contador);
                    puntuacion.repaint();
                }

                //serpiente.get(0).setLocation(serpiente.get(0).getX()+x, serpiente.get(0).getY()+y);
                for (int i = serpiente.size() - 1;
                        i > 0; i--) {
                    serpiente.get(i).setLocation(serpiente.get(i - 1).getLocation());
                    serpiente.get(i).repaint();
                }

                serpiente.get(
                        0).setLocation(serpiente.get(0).getX() + x, serpiente.get(0).getY() + y);

            }

            private void Actualizar() throws FileNotFoundException, IOException {
                colaLista cola = new colaLista();
                int con = 0;
                Nodo p = ptr;
                do {
                    if (p.getUser().equals(usuario)) {
                        System.out.println("ESta cambiando el score");

                        p.setScore(Integer.toString(contador));
                        System.out.println("cambiando el score");
                        System.out.println("asi esta el contador; " + contador);
                        System.out.println("asi quedo en la lista" + p.getScore());
                    }
                    p = p.getrLink();
                } while (p != null);
                Nodo q = ptr;
                do {
                    cola.insertar(concatenar(q));
                    q = q.getrLink();
                } while (!(q == null));
                Rescribir(cola);
            }

            public String concatenar(Nodo e) {
                String registro = "";
                System.out.println(e.nombre);
                registro = e.nombre + ";" + e.apellido + ";" + e.user + ";" + e.password + ";" + e.Score + ";";
                System.out.println(registro);
                return registro;
            }

            private void Rescribir(colaLista c) throws IOException {
                boolean continuar;
                System.out.println(c.contar());
                File b = new File("usuarios.txt");
                b.delete();
                File f = new File("usuarios.txt");
                continuar = c.estaVacia();
                Nodo p = ptr;
                try (
                        FileWriter fr = new FileWriter(f, true); BufferedWriter bw = new BufferedWriter(fr); PrintWriter pw = new PrintWriter(bw)) {
                    //bw.newLine();
                    do {
                        pw.print(c.extraer());
                        bw.newLine();
                        p = p.getrLink();
                    } while (p != null);

                    bw.close();
                    pw.close();
                }
            }

        }
        );
        ventana.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //subir
                if ((e.getKeyCode() == KeyEvent.VK_UP) && restV == true) {
                    System.out.println("arriba");
                    restV = false;
                    restH = true;
                    if (serpiente.get(0).getY() > 0) {
                        y = -desplazamiento;
                        x = 0;
                        serpiente.get(0).setIcon(new ImageIcon("imagenes/5.png"));
                    }
                    if (ban == 0) {
                        tiempo.start();
                        ban = 1;
                    }
                }

                //bajar
                if ((e.getKeyCode() == KeyEvent.VK_DOWN) && restV == true) {
                    System.out.println("baja");
                    restV = false;
                    restH = true;
                    if (serpiente.get(0).getY() < 600) {
                        y = desplazamiento;
                        x = 0;
                        serpiente.get(0).setIcon(new ImageIcon("imagenes/3.png"));
                    }
                    if (ban == 0) {
                        tiempo.start();

                        ban = 1;
                    }
                }
                //izquierda
                if ((e.getKeyCode() == KeyEvent.VK_LEFT) && restH == true) {
                    System.out.println("izquierda");
                    restV = true;
                    restH = false;
                    if (serpiente.get(0).getX() > 0) {
                        y = 0;
                        x = -desplazamiento;
                        serpiente.get(0).setIcon(new ImageIcon("imagenes/4.png"));
                    }
                    if (ban == 0) {
                        tiempo.start();
                        ban = 1;
                    }
                }
                //derecha
                if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && restH == true) {
                    System.out.println("derecha");
                    restV = true;
                    restH = false;
                    if (serpiente.get(0).getX() < 600) {
                        y = 0;
                        x = desplazamiento;
                        serpiente.get(0).setIcon(new ImageIcon("imagenes/2.png"));
                    }
                    if (ban == 0) {
                        tiempo.start();

                        ban = 1;
                    }
                }
                if ((e.getKeyCode() == KeyEvent.VK_SHIFT)) {
                    if (pause == false) {
                        System.out.println("PAUSA");
                        iconplay.setVisible(true);
                        iconpause.setVisible(false);
                        tiempo.stop();
                        pause = true;
                    } else {
                        iconplay.setVisible(false);
                        iconpause.setVisible(true);
                        System.out.println("REANUDAR");
                        tiempo.restart();
                        pause = false;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        ventana.setVisible(true);
    }//fin del constructor 

}//fin de la clase juego
