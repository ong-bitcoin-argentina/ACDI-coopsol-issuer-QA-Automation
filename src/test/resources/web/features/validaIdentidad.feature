@BO @regresion @validaIdentidad @credenciales

Feature: Validar identidad

  Como admin de Coopsol
  quiero acceder a Validacion de Identidades
  para poder visualizar solicitudes Aprobadas, Rechazadas y/o revertir las Rechazadas.

  @Ignore #MM-903
  Scenario: Validar una Solicitud Pendiente
    Given que el admin esta logueado en la web de coopsol.
    And el admin tiene al menos una solicitud pendiente
    When el admin selecciona "Validación de identidades"
    When el admin selecciona "Solicitudes Pendientes"
    When el admin selecciona una solicitud pendiente
    When hago click en el boton 'Validar'
    Then se muestran un mensaje de "Solicitud de validación de identidad aprobada"

  @Ignore #MM-905
  Scenario Outline: Rechazar una Solicitud Pendiente
    Given que el admin esta logueado en la web de coopsol.
    And el admin tiene al menos una solicitud pendiente
    When el admin selecciona "Validación de identidades"
    When el admin selecciona "Solicitudes Pendientes"
    When el admin selecciona una solicitud pendiente
    When hago click en el boton 'Rechazar'
    When el admin selecciona el motivo de rechazo: <Motivo_de_Rechazo>
    When hago click en el boton 'Validar'
    Then se muestran un mensaje de "Solicitud de validación de identidad rechazada"

    Examples:
      | Motivo_de_Rechazo          |
      | Datos Inconsistentes       |
      | No es posible comunicarse  |
      | No es productor de coopsol |

  #MM-902 #MM-907 #MM-908
  Scenario Outline: Visualizar listado de Solicitudes <estado_identidad>
    Given que el admin esta logueado en la web de coopsol.
    When el admin se encuentra en "Validación de identidades"
    When el admin selecciona "<tab>"
    Then se visualizan todas las solicitudes en estado <estado_identidad>

    Examples:
      | estado_identidad | tab                    |
      | Pendiente        | Solicitudes Pendientes |
      | Aprobada         | Solicitudes Aprobadas  |
      | Rechazada        | Solicitudes Rechazadas |


  @smoke  #MM-909
  Scenario: Revertir Solicitudes Rechazadas exitosamente.
    Given que el admin esta logueado en la web de coopsol.
    And  el admin se encuentra en "Validación de identidades"
    When el admin selecciona "Solicitudes Rechazadas"
    When el admin selecciona una solicitud
    When el admin selecciona "Revertir Rechazo"
    When hago click en el boton 'Confirmar'
    Then se visualiza mensaje "Solicitud revertida correctamente."



