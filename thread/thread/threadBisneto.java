/* ***************************************************************
* Autor............: Carlos Gil Martins da Silva
* Matricula........: 202110261
* Inicio...........: 18/03/2023
* Ultima alteracao.: 22/03/2023
* Nome.............: Arvore Genealogica utilizando Threads
* Funcao...........: Thread do Bisneto, Seta um controlador comum, controla
a idade do bisneto e altera sua imageView, escrve no terminal quando nasce
e quando morre, e segura 1sec a cada um ano de idade
****************************************************************/

package thread;

import control.controllerGeral;

public class threadBisneto extends Thread {
  controllerGeral cG = new controllerGeral(); // Instancia do Controller

  // Metodo Utilizado para Setar um Controlador em Comum em Todas Threads
  public void setControlador(controllerGeral controle) {
    this.cG = controle;
  }

  @Override
  public void run() { // Inicio Run
    System.out.println("Bisneto Nasceu"); 
    try {
      for (int i = 0; i <= 12; i++) { // For até a idade de morte
        
        if (i == 7) { // If para atualizar imagem
          cG.UpdateImage("Filho01", "assets/Idade2.png"); //Atualiza imagem Bisneto
        }
        
        cG.UpdateAge("Bisneto", i); // Atualiza idade Bisneto
        sleep(1000); // Segura 1 segudo cada rodagem do for
      } // Fim for
    } // Fim Try
    catch (InterruptedException e) {
    }
    cG.UpdateImage("Bisneto", "assets/idade5.png"); // Atualiza imagem Bisneto
    System.out.println("Bisneto Morreu aos 12 Anos de Idade");

  }// Fim run
}
