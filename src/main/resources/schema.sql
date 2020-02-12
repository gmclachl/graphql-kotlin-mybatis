CREATE table recipe(
  id int primary key,
  recipe_name VARCHAR(50) NOT NULL
);

INSERT INTO recipe(id, recipe_name) VALUES
(1, 'Pie'),
(2, 'Sandwich');

