/* ***************************************************************
* Autor............: Carlos Gil Martins da Silva
* Matricula........: 202110261
* Inicio...........: 18/03/2023
* Ultima alteracao.: 22/03/2023
* Nome.............: Arvore Genealogica em C++
* Funcao...........: Arvore Genealogica em C++ utilizando os comandos Fork
*************************************************************** */

#include <unistd.h>
#include <iostream>
using namespace std;

int main(void){
  pid_t idProcesso; // identificando o processo
  cout << "inicio da Simulacao" << endl;
  idProcesso = fork(); // Criando o Processo

  switch (idProcesso){        // Switch 01
  case -1: // erro
    cout << "Erro de Criacao!";
    exit(1);

  case 0: // retorno para o processo fiho
    sleep(22);
    cout << "Nascimento do [Primeiro Filho]" << endl;
    cout << "Id do [ Pai ]: " << getppid() << endl;
    cout << "Id do [ Filho ]: " << getpid() << endl;
    cout << endl;
    idProcesso = fork();

    switch (idProcesso){        // Switch 02
    case -1: // erro
      cout << "Erro de Criacao!";
      exit(1);

    case 0: // Processo para Neto
      sleep(16);
      cout << "Nascimento do [Primeiro Neto]" << endl;
      cout << "Id do [ Pai ]: " << getppid() << endl;
      cout << "Id do [ Filho ]: " << getpid() << endl;
      cout << endl;
      idProcesso = fork();

      switch (idProcesso){        // Switch 03
      case -1: // erro
        cout << "Erro de Criacao!";
        exit(1);

      case 0:  // Processo para Bisneto
        sleep(30); // Aguarda 30 Sec
        cout << "Nascimento do [Bisneto]" << endl;
        cout << "Id do [ Pai ]: " << getppid() << endl;
        cout << "Id do [ Filho ]: " << getpid() << endl;
        cout << endl;
        sleep(12); // Aguarda os Segundos (Idade de Vida) Para Matar
        cout << "Morreu o [ Bisneto ]" << endl;
        exit(0);
        break;
      } // Switch 03

      sleep(35); // Aguarda os Segundos (Idade de Vida) Para Matar
      cout << "Morreu o [ Primeiro Neto ]" << endl;
      exit(0);
    } // Switch 02

    sleep(61); // Aguarda os Segundos (Idade de Vida) Para Matar
    cout << "Morreu o [ Primeiro Filho ]" << endl;
    exit(0);
    break;

  default: // retorno para o processo pai
    cout << "Nascimento do [Pai]" << endl;
    cout << "Id do [ Pai ]: " << getppid() << endl;
    cout << endl;
    idProcesso = fork();

    switch (idProcesso){        // Switch 04
    case -1: // erro
      cout << "Erro de Criacao!";
      exit(1);
      
    case 0: // Processo para Segundo Filho
      sleep(25);
      cout << "Nascimento do [Segundo Filho]" << endl;
      cout << "Id do [ Pai ]: " << getppid() << endl;
      cout << "Id do [ Filho ]: " << getpid() << endl;
      cout << endl;
      idProcesso = fork();

      switch (idProcesso){        // Switch 05
      case -1: // erro
        cout << "Erro de Criacao!";
        exit(1);

      case 0: // Processo para Segundo Neto
        sleep(20);
        cout << "Nascimento do [Segundo Neto]" << endl;
        cout << "Id do [ Pai ]: " << getppid() << endl;
        cout << "Id do [ Filho ]: " << getpid() << endl;
        cout << endl;

        sleep(33); // Aguarda os Segundos (Idade de Vida) Para Matar
        cout << "Morreu o [ Segundo Neto ]" << endl;
        exit(0);
        break;
      } // Switch 05

      sleep(55); // Aguarda os Segundos (Idade de Vida) Para Matar
      cout << "Morreu o [ Segundo Filho ]" << endl;
      exit(1);
      break;
    } // Switch 04
    idProcesso = fork();
    switch (idProcesso){        // Switch 06
    case -1: // erro
      cout << "Erro de Criacao!";
      exit(1);

    case 0: // Processo para Terceiro Filho
      sleep(32);
      cout << "Nascimento do [Terceiro Filho]" << endl;
      cout << "Id do [ Pai ]: " << getppid() << endl;
      cout << "Id do [ Filho ]: " << getpid() << endl;
      cout << endl;

      sleep(55); // Aguarda os Segundos (Idade de Vida) Para Matar
      cout << "Morreu o [ Terceiro Filho ]" << endl;
      exit(0);
      break;
    } // Switch 06
    sleep(90); // Aguarda os Segundos (Idade de Vida) Para Matar
    cout << "Morreu o [ Pai ]" << endl;
    exit(0);
    break;
  } // fim do switch 01
} // fim do metodo main