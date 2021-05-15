/*Select vendedor*/
SELECT vendedor.*,departamento.Nome as DepName
FROM vendedor INNER JOIN departamento
ON vendedor.Id_dpt = departamento.ID
WHERE vendedor.ID = ?

/*select departamento*/
SELECT vendedor.*,departamento.Nome as DepName
FROM vendedor INNER JOIN departamento
ON vendedor.Id_dpt = departamento.ID
WHERE Id_dpt = ?
ORDER BY Nome