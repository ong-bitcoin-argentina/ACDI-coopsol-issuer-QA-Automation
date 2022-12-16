@BO @regresion @smoke @credenciales
Feature: Credenciales - Filtros
  Como usuario de Coopsol
  quiero acceder a credenciales en uso para poder
  REVOCARLAS segun FILTRO aplicado

  #MM-815
  @Giuliana
  Scenario Outline: Filtros de busqueda Exitoso
    Given que el admin esta logueado en la web de coopsol.
    When el admin selecciona "Credenciales"
    When el admin selecciona "Credenciales en uso"
    When el admin completa el filtro "Tipo:" <Tipo>, "Nombre:" <Nombre>, "Apellido:" <Apellido>, "Desde:" <Desde>, "Hasta:" <Hasta>
    Then se muestran los resultados de acuerdo al criterio de busqueda

    Examples:
      | Tipo           | Nombre | Apellido | Desde      | Hasta      |
      | Productiva RSK | David  | Morelos  | 08/08/2022 | 08/08/2022 |
     # |              | Emiliano | Palacio  | 26/07/2022 | 29/07/2022 |
     # |              |          | Palacio  | 26/07/2022 | 29/07/2022 |
     # |              |          |          | 26/07/2022 | 29/07/2022 |
     # |              |          |          |            | 29/07/2022 |
     # |              | Emiliano | Palacio  | 26/07/2022 | 29/07/2022 |
     # | Crowdar-Test | Emiliano |          | 26/07/2022 |            |
     # | Crowdar-Test |          | Palacio  |            | 29/07/2022 |


