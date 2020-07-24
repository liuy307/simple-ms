select * from user, user_role, role
where user.id = user_role.user_id
and user_role.role_id = role.id

select * 
from user 
left join user_role on user.id = user_role.user_id
left join role on user_role.role_id = role.id