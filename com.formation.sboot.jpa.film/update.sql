use sakila;
update film set language_id=5
where ( title like '%french%' or description like '%cow%' ) ;