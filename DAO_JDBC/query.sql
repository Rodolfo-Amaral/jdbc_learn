SELECT vendedor.*,departamento.Nome as DepName
FROM vendedor INNER JOIN departamento
ON vendedor.Id_dpt = departamento.ID
WHERE vendedor.ID = ?