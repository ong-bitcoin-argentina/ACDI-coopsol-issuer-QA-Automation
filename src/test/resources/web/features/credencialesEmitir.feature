 @BO @regresion @smoke @credenciales

 Feature: Credenciales - Emisión

   Como usuario de Coopsol
   quiero emitir credenciales pendientes


 ##MM-835
   Scenario: Emitir Exitosamente credenciales pendientes
     Given estoy logueado en la web de coopsol con el usuario "crowdar" y password "Crowdar387!"
     When hago click en Emitir
     Then se muestra el mensaje "Se ha emitido exitosamente la credencial"