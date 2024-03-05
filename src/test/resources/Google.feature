Feature: Probar la busqueda en Google

  Scenario: Busco algo en Google
  Given navegar a google
  When busco algo
  Then obtengo resultados
