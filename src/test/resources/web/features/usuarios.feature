@BO @smoke @regresion @usuario
Feature: Usuarios

  Como usuario de Coopsol quiero acceder a "Usuarios"
  para poder realizar ABM

  #MM-821
  Scenario Outline: Creacion de usuario Exitosa
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Usuarios"
    When el admin selecciona "+ Nuevo Usuario"
    When el admin completa el formulario con "Nombre:" <Nombre>, "Contraseña:" <Pass> y "Roles:" <Rol>
    Then el usuario se crea exitosamente

    Examples:
      | Nombre     | Pass     | Rol   |
      | Emiliano   | !@#!@#   | Admin |
      | Juan Perez | 23423424 | Basic |