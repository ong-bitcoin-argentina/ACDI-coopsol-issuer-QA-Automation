@BO @regresion @smoke @credenciales

Feature: Credenciales

  Como usuario de Coopsol
  quiero eliminar una  credencial pendiente

  @Ignore
  Scenario: Eliminar exitosamente una credencial pendiente
    Given que el admin esta logueado en la web de coopsol.
    When selecciono la primer credencial haciendo click en el checkbox ubicado a la izquierda
    When hago click en el boton "ELIMINAR SELECCIONADOS”
    Then se muestra el mensaje "Se ha revocado exitosamente la credencial"


