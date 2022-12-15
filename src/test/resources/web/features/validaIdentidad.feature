@BO @regresion @validaIdentidad @credenciales

Feature: Validar identidad

  Como admin de Coopsol
  quiero acceder a Validacion de Identidades
  para poder visualizar solicitudes Aprobadas, Rechazadas y/o revertir las Rechazadas.

  #MM-903
  Scenario: Validar una Solicitud Pendiente
    Given que el admin esta logueado en la web de coopsol.
    And el admin tiene al menos una solicitud pendiente
    When el admin hace click en  el área "Validación de Identidades"
    And el admin selecciona una "Solicitud Pendiente” haciendo click en validar”
    And el admin hace click nuevamente en el botón “Validar”
    Then se muestra un mensaje de “Solicitud de validación de identidad aprobada.”

  #MM-905
  Scenario Outline: rechazar una Solicitud Pendiente
    Given que el admin esta logueado en la web de coopsol.
    And el admin tiene al menos una solicitud pendiente
    When el admin selecciona el área "Validación de Identidades"
    And el admin se dirige a la sección "Solicitudes Pendientes"
    And el admin da click en el botón “Rechazar”
    And el admin selecciona el motivo de rechazo: <Motivo de Rechazo>
    And el admin da click en el botón “Rechazar”
    Then se muestra un mensaje de “Solicitud de validación de identidad rechazada”

    Examples:
      | Motivo de Rechazo          |
      | Datos Inconsistentes       |
      | No es posible comunicarse  |
      | No es productor de coopsol |

  #MM-902
  Scenario: Visualizar listado de  Solicitud Pendiente
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona el área "Validación de Identidades"
    Then se muestra un listado de solicitudes pendiente


  #MM-907
  Scenario: Vizualizar Solicitudes Aprobadas exitosamente.
    Given que el admin esta logueado en la web de coopsol.
    And el admin se encuentra en "Validacion de Identidades"
    When el admin selecciona "Solicitudes Aprobadas"
    Then se visualilza el tab "Solicitudes Aprobadas"


  #MM-908
  Scenario: Vizualizar Solicitudes Rechazadas exitosamente.
    Given que el admin esta logueado en la web de coopsol.
    And el admin se encuentra en "Validacion de Identidades"
    And el admin tiene al menos una solicitud pendiente
    When el admin selecciona "Solicitudes Rechazadas"
    Then se visualilza las "Solicitudes Rechazadas"


  @smoke  #MM-909
  Scenario: Revertir Solicitudes Rechazadas exitosamente.
    Given que el admin esta logueado en la web de coopsol.
    And  el admin se encuentra en "Validacion de Identidades"
    And el admin se encuentra en  "Solicitudes Rechazadas"
    When el  admin selecciona "Revertir Rechazo" del primer resultado
    And el admin hace click "Confirmar"
    Then se visualilza mensaje "Solicitud revertida correctamente."


