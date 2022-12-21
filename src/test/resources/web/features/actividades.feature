@BO @regresion @actividades
Feature: Actividades
  Como usuario de Coopsol Issuer
  Quiero ver las actividades de los usuarios

  ##MM-837
  @Demo
  Scenario: Visualizar el listados de actividades
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Actividades"
    Then se muestra un listado con las actividades de los usuarios.