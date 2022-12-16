@BO @smoke @regresion @usuario
Feature: Usuarios

  Como usuario de Coopsol quiero acceder a "Usuarios"
  para poder realizar ABM
#TODO completar
  #El nombre se genera de forma dinámica y queda concatenado al que se muestra en el example
  #MM-821
  Scenario Outline: Creacion de usuario Exitosa
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Usuarios"
    When el admin selecciona "+ Nuevo Usuario"
    When el admin completa el formulario con "Nombre:" <Nombre>, "Contraseña:" <Pass> y "Roles:" <Rol>
    When Hace click en el boton "Guardar"
    Then el usuario se crea exitosamente con "Nombre:" <Nombre> y "Roles:" <Rol>
@Nahuel
    Examples:
      | Nombre     | Pass     | Rol   |
      | Emiliano   | !@#!@#   | ADMIN |
#      | Juan Perez | 23423424 | BASIC |