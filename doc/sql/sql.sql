delete
from book_content8
where index_id in (select id from book_index where book_id = 1990269641911709696)
  and index_id % 10 = 8;
delete
from book_content7
where index_id in (select id from book_index where book_id = 1990269641911709696)
  and index_id % 10 = 7;
delete
from book_content6
where index_id in (select id from book_index where book_id = 1990269641911709696)
  and index_id % 10 = 6;
delete
from book_content5
where index_id in (select id from book_index where book_id = 1990269641911709696)
  and index_id % 10 = 5;
delete
from book_content4
where index_id in (select id from book_index where book_id = 1990269641911709696)
  and index_id % 10 = 4;
delete
from book_content3
where index_id in (select id from book_index where book_id = 1990269641911709696)
  and index_id % 10 = 3;
delete
from book_content2
where index_id in (select id from book_index where book_id = 1990269641911709696)
  and index_id % 10 = 2;
delete
from book_content1
where index_id in (select id from book_index where book_id = 1990269641911709696)
  and index_id % 10 = 1;
delete
from book_content0
where index_id in (select id from book_index where book_id = 1990269641911709696)
  and index_id % 10 = 0;
delete
from book_content
where index_id in (select id from book_index where book_id = 1990269641911709696);

delete from book_index where book_id = 1990269641911709696;