select *
from unfinish,unfinish_class
where unfinish.unfinish_class_id = unfinish_class.unfinish_class_id;

select unfinish_class_name,count(*) as'number'
from unfinish,unfinish_class
where unfinish.unfinish_class_id =  unfinish_class.unfinish_class_id and user_id = 1010
group by unfinish_class_name;


select *
from note
where user_id= 1010 and delete_time is null
order by top_time desc,note_date desc;