DROP PROCEDURE IF EXISTS hanukkah.date_pro;
DROP PROCEDURE IF EXISTS hanukkah.date_pro2;

delimiter //
create procedure date_pro(IN num INT, IN courseType INT)
begin
while num < 50 do
set @courseDate = '2017-11-09 12:12:33';
set @batchNo = 10;
set @invalidDate = '2027-11-09 12:12:33';
insert into wusong_course(id, title, lecturer, course_date, price, picture_url, type, create_date, modify_date)
  values(concat("", num), concat("课程测试", num), concat("导师", num), date_add(@courseDate, interval num second),
        10+num, concat("/test", num), courseType, now(), null) ;
insert into wusong_course_code(id, wusong_course_id, code, invitation_url, status, import_batch_no, create_date, invalid_date, modify_date)
  values(concat("", num), num, concat("code", num), "http%3a%2f%2fwechatapppro-1252524126.file.myqcloud.com%2fappm83Ur8Pq7478%2fimage%2fabf69a6694e7f87cc7ece5b7a80d8cba.jpg", 1, @batchNo, now(), date_add(@invalidDate, interval num second),
        null) ;

    CALL date_pro2(num);


set num=num+1;
end while;
end
 //

delimiter //
create procedure date_pro2(IN courseId INT)
begin
declare count int;
    set count=1;
    while count < 300 do
    insert into wusong_course_code(id, wusong_course_id, code, invitation_url, status, import_batch_no, create_date, invalid_date, modify_date)
  values(UUID(), courseId, concat("code", count), "https%3a%2f%2fh5.xiaoeknow.com%2fappm83Ur8Pq7478%2fgiftcode%2f1432493760493255", 1, @batchNo, now(), date_add(@invalidDate, interval 1 second),
        null) ;
    set count=count+1;
    END WHILE ;
end
 //


call date_pro(1, 1);