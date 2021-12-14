insert into user(email, name, nickname, password, enabled, phone, address, regdate, moddate)
values
    ('user1@domain.com', 'user1', 'egg', 'user1-pw', true, '010-0000-0000', 'simple address', now(), now()),
    ('user2@domain.com', 'user2', 'morning', 'user2-pw', true, '010-0000-0000', 'simple address', now(), now());

INSERT INTO hotel(name, address, phone, level, rating, thumbnail, regdate, moddate)
VALUES
    ("포시즌스 호텔 서울", "서울 종로구 새문안로 9", "02-6388-5000", 5, 9.3, "https://www.fourseasons.com/alt/img-opt/~80.930.0,0000-144,2500-3000,0000-1687,5000/publish/content/dam/fourseasons/images/web/SKO/SKO_757_original.jpg", now(), now()),
    ("신라 호텔 서울", "서울시 중구 동호로 249", "02-2233-3131", 5, 9.2, "https://www.shilla.net/images/contents/dining/PAR/R0000000081Z_KR.jpg", now(), now()),
    ("시그니엘 서울", "서울특별시 송파구 올림픽로 300 롯데월드타워 76-101층", "02-3213-1000", 5, 9.2, "https://www.lottehotel.com/content/dam/lotte-hotel/signiel/seoul/promotion/offering/2454-768-din-LTSG.jpg.thumb.1440.1440.jpg", now(), now()),
    ("그랜드 머큐어 앰배서더 호텔 앤 레지던스 서울 용산", "서울시 용산구 청파로 20길 95", "02-2223-7000", 4, 9.1, "https://www.ambatel.com/RES/PRODUCT/201804/fe1PC1216x608_20180406174650.png", now(), now()),
    ("JW 메리어트 호텔 서울", "서초구 신반포로 176", "02-6282-6407", 4, 8.9, "https://cache.marriott.com/marriottassets/marriott/SELJW/seljw-flavors-0046-hor-clsc.jpg?downsize=580px:*", now(), now()),
    ("웨스틴 조선호텔 서울", "서울시 중구 소공로 106", "02-771-0500", 5, 8.8, "https://cache.marriott.com/marriottassets/marriott/SELWI/selwi-restaurant-aria-2561-hor-clsc.jpg?interpolation=progressive-bilinear&downsize=580px:*", now(), now()),
    ("롯데시티호텔 명동", "서울특별시 중구 삼일대로 362", "02-6112-1000", 4, 8.7, "https://www.lottehotel.com/content/dam/lotte-hotel/city/myeongdong/dining/restaurant/saffron-dining/1449-3-2000-din-LTMC.jpg.thumb.1920.1920.jpg", now(), now());
