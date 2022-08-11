select * from user_product up inner join user u
                                         on up.email=u.email
                              inner join product p
                                         on up.name=p.name;