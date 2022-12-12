@BO @regresion @smoke @validacionDeIdentidad
Feature: Visualizar solicitudes
  Como admin de Coopsol
  quiero acceder a Validacion de Identidades
  para poder visualizar las Solicitudes Aprobadas.

  #MM-907
  Scenario: Vizualizar Solicitudes Aprobadas exitosamente.
    Given que el admin esta logueado en la web de coopsol.
    And el admin se encuentra en "Validación de identidades"
    When el admin selecciona "Solicitudes Aprobadas"
    Then se visualilza el tab Solicitudes Aprobadas