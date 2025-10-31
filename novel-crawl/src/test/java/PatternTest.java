// import java.util.regex.Pattern;
//
// public class PatternTest {
//     public static void main(String[] args) {
//         String url = h1();
//         String regex = "作者：<(?:a[^>]*>|span>)([^<]+)";
//         var pattern = Pattern.compile(regex);
//         var matcher = pattern.matcher(url);
//         while (matcher.find()) {
//             var s = matcher.group(1);
//             System.out.println(s);
//         }
//         System.out.println("end......");
//     }
//
//     private static String h1() {
//         return "\n" +
//                 "<!DOCTYPE html>\n" +
//                 "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"zh-Hans\">\n" +
//                 "\n" +
//                 "<head>\n" +
//                 "        <meta name=\"renderer\" content=\"webkit\" />\n" +
//                 "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
//                 "    <link rel=\"icon\" type=\"image/png\" href=\"/images/sites/favicon/3.png?v=1.0.1\" />\n" +
//                 "    <meta name=\"keywords\" content=\"老婆雪儿的换妻经验,蓓蓓,\" />\n" +
//                 "    <meta name=\"description\" content=\"我与老婆今天都25岁，是大学认识的，现在都供职在外企单位，生活质量很不错，但压力也蛮大。当时刚见到雪儿的时候我刚和初恋分手，在心灵最空虚的时候，这个乖巧可爱的女孩就蹦进我的生活。老婆属于那种娇小的小美女，羞涩迷人，一张洋娃娃般美丽、精致的小脸，天生一副楚楚可怜的摸样，但她却有着傲人的身材，1米60的身高才40多kg，丰满而盈润的两个乳房和翘翘的小屁股，让无数男人垂涎三尺，一双美腿和精致的小手小脚更是让人心醉。\" />\n" +
//                 "    <title>第一章 一切的开始 - 老婆雪儿的换妻经验 - 成人小说网</title>\n" +
//                 "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\">\n" +
//                 "    <meta name=\"RATING\" content=\"RTA-5042-1996-1400-1577-RTA\" />\n" +
//                 "    <meta name=\"rating\" content=\"adult\" />\n" +
//                 "    <meta name=\"twitter:card\" content=\"summary_large_image\" />\n" +
//                 "    <meta name=\"twitter:title\" content=\"第一章 一切的开始 - 老婆雪儿的换妻经验\" />\n" +
//                 "    <meta name=\"twitter:description\" content=\"我与老婆今天都25岁，是大学认识的，现在都供职在外企单位，生活质量很不错，但压力也蛮大。当时刚见到雪儿的时候我刚和初恋分手，在心灵最空虚的时候，这个乖巧可爱的女孩就蹦进我的生活。老婆属于那种娇小的小美女，羞涩迷人，一张洋娃娃般美丽、精致的小脸，天生一副楚楚可怜的摸样，但她却有着傲人的身材，1米60的身高才40多kg，丰满而盈润的两个乳房和翘翘的小屁股，让无数男人垂涎三尺，一双美腿和精致的小手小脚更是让人心醉。\" />\n" +
//                 "    <meta name=\"twitter:image\" content=\"https://upload.xchina.io/fiction/5fb6466e43a25.jpg\" />\n" +
//                 "    <meta property=\"og:site_name\" content=\"成人小说网\" />\n" +
//                 "    <meta property=\"og:type\" content=\"website\" />\n" +
//                 "    <meta property=\"og:url\" content=\"https://crxs.me/fiction/id-5fb6466e43a25.html\" />\n" +
//                 "    <meta property=\"og:title\" content=\"第一章 一切的开始 - 老婆雪儿的换妻经验\" />\n" +
//                 "    <meta property=\"og:description\" content=\"我与老婆今天都25岁，是大学认识的，现在都供职在外企单位，生活质量很不错，但压力也蛮大。当时刚见到雪儿的时候我刚和初恋分手，在心灵最空虚的时候，这个乖巧可爱的女孩就蹦进我的生活。老婆属于那种娇小的小美女，羞涩迷人，一张洋娃娃般美丽、精致的小脸，天生一副楚楚可怜的摸样，但她却有着傲人的身材，1米60的身高才40多kg，丰满而盈润的两个乳房和翘翘的小屁股，让无数男人垂涎三尺，一双美腿和精致的小手小脚更是让人心醉。\" />\n" +
//                 "    <meta property=\"og:image\" content=\"https://upload.xchina.io/fiction/5fb6466e43a25.jpg\" />\n" +
//                 "        <meta name=\"referrer\" content=\"always\" />\n" +
//                 "    <link rel=\"stylesheet\" href=\"/plugins/fontawesome-free-6.7.2-web/css/all.min.css\" />\n" +
//                 "            <link rel=\"stylesheet\" href=\"/css/dst/main.min.css?v=1.1.14\" />\n" +
//                 "                            <link rel=\"stylesheet\" href=\"/extra/extra.css?v=1.0.1\" />\n" +
//                 "                <script src=\"/scripts/jquery-3.5.1.min.js\"></script>\n" +
//                 "    <script src=\"/scripts/jquery.blockUI.min.js\"></script>\n" +
//                 "    <script src=\"/scripts/modal/modal.js?v=1.0.5\"></script>\n" +
//                 "    <script src=\"/plugins/sweetAlert2/sweetalert2.all.min.js\"></script>\n" +
//                 "    <script src=\"/scripts/push.js?v=1.0.2\"></script>\n" +
//                 "    <script src=\"/scripts/my.js?v=1.0.3\"></script>\n" +
//                 "    <script src=\"/scripts/comment.js?v=1.0.12\"></script>\n" +
//                 "    <link rel=\"stylesheet\" href=\"/css/avatars/avatar.css?v=1.0.16\">    <link rel=\"canonical\" href=\"https://crxs.me/fiction/id-5fb6466e43a25.html\" />\n" +
//                 "        <meta http-equiv=\"content-language\" content=\"zh-Hans\" />\n" +
//                 "    <meta http-equiv=\"Delegate-CH\" content=\"Sec-CH-UA https://s.magsrv.com; Sec-CH-UA-Mobile https://s.magsrv.com; Sec-CH-UA-Arch https://s.magsrv.com; Sec-CH-UA-Model https://s.magsrv.com; Sec-CH-UA-Platform https://s.magsrv.com; Sec-CH-UA-Platform-Version https://s.magsrv.com; Sec-CH-UA-Bitness https://s.magsrv.com; Sec-CH-UA-Full-Version-List https://s.magsrv.com; Sec-CH-UA-Full-Version https://s.magsrv.com;\" />\n" +
//                 "        <div class=\"push-top-container\"><div class=\"push-top\" key=\"clicked_cpt_429\" clickmode=\"cpt\" clickid=\"429\" url=\"https://platform.usz88.com/sz/index8.html\"><div class=\"media\" style=\"background-image: url(https://upload.xchina.io/media/686cd9151dca4.webp);\"></div><div class=\"close\"><i class=\"fas fa-xmark\"></i></div></div><div class=\"push-top\" key=\"clicked_cpt_438\" clickmode=\"cpt\" clickid=\"438\" url=\"https://k7ba8p.jnkh.cn/13173e00/f5ea47.html?shareName=xbook\"><div class=\"media\" style=\"background-image: url(https://upload.xchina.io/media/68a1ce2c895ae.webp);\"></div><div class=\"close\"><i class=\"fas fa-xmark\"></i></div></div><div class=\"push-top\" key=\"clicked_cpt_461\" clickmode=\"cpt\" clickid=\"461\" url=\"https://hlw934.life/?a=ygzi87\"><div class=\"media\" style=\"background-image: url(https://upload.xchina.io/media/68dcf82e84cf8.webp);\"></div><div class=\"close\"><i class=\"fas fa-xmark\"></i></div></div><div class=\"push-top\" key=\"clicked_cpt_458\" clickmode=\"cpt\" clickid=\"458\" url=\"https://luoli.sbs\"><div class=\"media\" style=\"background-image: url(https://upload.xchina.io/media/68db9c9025e40.webp);\"></div><div class=\"close\"><i class=\"fas fa-xmark\"></i></div></div></div><div class=\"push-slider\" key=\"clicked_cpt_464\" clickmode=\"cpt\" clickid=\"464\" url=\"https://hlw934.life/?a=ygzi87\"><div class=\"media\"><video class=\"vid\" preload=\"metadata\" muted autoplay><source src=\"https://upload.xchina.io/media/68dd29ad98a0e.mp4\" type=\"video/mp4\" /></video></div><div class=\"close\">关闭</div></div><div class=\"push-slider\" key=\"clicked_cpt_427\" clickmode=\"cpt\" clickid=\"427\" url=\"https://longfenga.top/?xchina3\"><div class=\"media\"><video class=\"vid\" preload=\"metadata\" muted autoplay><source src=\"https://upload.xchina.io/media/686a4f879f37e.mp4\" type=\"video/mp4\" /></video></div><div class=\"close\">关闭</div></div><div class=\"push-bottom-container\" key=\"clicked_cpt_422\" clickmode=\"cpt\" clickid=\"422\" url=\"https://www.lanmao18.top/?code=6qQCDVHN\"><div class=\"push-bottom\"><div class=\"close\">关闭</div><div class=\"media\"><img src=\"https://upload.xchina.io/media/68650218b4246.webp\" /></div></div></div>            <script>\n" +
//                 "    let __user;\n" +
//                 "    try {\n" +
//                 "        var tmpStr = my.getCookie(\"__login_user\");\n" +
//                 "        __user = tmpStr ? JSON.parse(tmpStr) : undefined;\n" +
//                 "    } catch (e) {\n" +
//                 "        __user = undefined;\n" +
//                 "    }\n" +
//                 "    $(document).ready(function () {\n" +
//                 "        try {\n" +
//                 "            my.initCopy(\"当前网址已复制\");\n" +
//                 "        } catch (e) {}\n" +
//                 "    });\n" +
//                 "</script><script>\n" +
//                 "    var favOptions = {\"enabled\":true,\"objMode\":\"fiction\",\"objId\":\"5fb6466e43a25\",\"isFaved\":false};\n" +
//                 "    var showFav = function() {\n" +
//                 "        if (favOptions.enabled) {\n" +
//                 "            if (favOptions.isFaved) {\n" +
//                 "                $(\"footer .menu-item.fav\").addClass(\"isFaved\");\n" +
//                 "                $(\"footer .menu-item.fav i\").removeClass(\"far\").addClass(\"fas\");\n" +
//                 "            } else {\n" +
//                 "                $(\"footer .menu-item.fav\").removeClass(\"isFaved\");\n" +
//                 "                $(\"footer .menu-item.fav i\").removeClass(\"fas\").addClass(\"far\");\n" +
//                 "            }\n" +
//                 "        }\n" +
//                 "    };\n" +
//                 "    var toggleFav = function () {\n" +
//                 "        if (favOptions.enabled) {\n" +
//                 "            if (!__user) {\n" +
//                 "                my.confirm(\"需要登录才能使用收藏功能，前去登录吗？\", function () {\n" +
//                 "                    location.href = \"https://xchina.online/?s=Tp1J366op4ksV_JyKdXxWVpGSnpDdENCS3RpMzdkUmFMK1VGcDRuZWxXUE1oN0crT09qeXVwWXp0cXRWWEtmaEhLOTBaOG9RalFjaVB1ZG1lYWp1N0JnQk1mckJJUVZZaTcxUFJVZUhzbXNsaGdsc3UvL2NJVHRXL05YSXpOTWIvcnFxd1ZtSFFGYVlKS1c0\";\n" +
//                 "                });\n" +
//                 "            } else {\n" +
//                 "                my.ajax({\n" +
//                 "                    action: \"toggleFavorite\",\n" +
//                 "                    objMode: favOptions.objMode,\n" +
//                 "                    objId: favOptions.objId\n" +
//                 "                }, function (result) {\n" +
//                 "                    switch (result.code) {\n" +
//                 "                        case 0:\n" +
//                 "                            favOptions.isFaved = result.favorited;\n" +
//                 "                            showFav();\n" +
//                 "                            if (typeof __showFav === 'function') {__showFav(result.favorited);};\n" +
//                 "                            my.success(favOptions.isFaved ? \"已加入收藏\" : \"已取消收藏\");\n" +
//                 "                            break;\n" +
//                 "                        default:\n" +
//                 "                            my.error(result.message);\n" +
//                 "                            break;\n" +
//                 "                    }\n" +
//                 "                });\n" +
//                 "            }\n" +
//                 "        }\n" +
//                 "    };\n" +
//                 "</script>    \n" +
//                 "<script type=\"application/ld json\">[{\"@context\":\"https:\\/\\/schema.org\",\"@type\":\"Article\",\"headline\":\"第一章 一切的开始\",\"datePublished\":\"2020-11-19T18:18:22 08:00\",\"dateModified\":\"2020-11-19T18:18:22 08:00\",\"description\":\"老婆雪儿的换妻经验 - 第一章 一切的开始\",\"url\":\"https:\\/\\/crxs.me\\/fiction\\/id-dGhpc19pc19hX2ZpeGVkMDMveGliUWtDUUVTU0N1VC9FcW95MlE9PQ==.html\",\"mainEntityOfPage\":\"https:\\/\\/crxs.me\\/fiction\\/id-dGhpc19pc19hX2ZpeGVkMDMveGliUWtDUUVTU0N1VC9FcW95MlE9PQ==.html\",\"inLanguage\":\"zh-Hans\",\"publisher\":{\"@type\":\"Organization\",\"name\":\"成人小说网\",\"url\":\"https:\\/\\/crxs.me\"},\"isPartOf\":{\"@context\":\"https:\\/\\/schema.org\",\"@type\":\"Article\",\"headline\":\"老婆雪儿的换妻经验\",\"datePublished\":\"2020-11-19T18:18:22 08:00\",\"dateModified\":\"2020-11-19T18:18:22 08:00\",\"description\":\"我与老婆今天都25岁，是大学认识的，现在都供职在外企单位，生活质量很不错，但压力也蛮大。当时刚见到雪儿的时候我刚和初恋分手，在心灵最空虚的时候，这个乖巧可爱的女孩就蹦进我的生活。老婆属于那种娇小的小美女，羞涩迷人，一张洋娃娃般美丽、精致的小脸，天生一副楚楚可怜的摸样，但她却有着傲人的身材，1米60的身高才40多kg，丰\",\"image\":\"https:\\/\\/upload.xchina.io\\/fiction\\/5fb6466e43a25.jpg\",\"url\":\"https:\\/\\/crxs.me\\/fiction\\/id-5fb6466e43a25.html\",\"mainEntityOfPage\":\"https:\\/\\/crxs.me\\/fiction\\/id-5fb6466e43a25.html\",\"inLanguage\":\"zh-Hans\",\"publisher\":{\"@type\":\"Organization\",\"name\":\"成人小说网\",\"url\":\"https:\\/\\/crxs.me\"},\"keywords\":\"1,3,10,12,16,101,102\",\"articleBody\":\"目录：\\n1. 第一章 一切的开始\\n2. 第二章 多年好友带来的转折\\n3. 第三章 最后的准备\\n4. 第四章 挖掘老婆的淫荡本质\\n5. 第五章 酒店春色\\n6. 第六章 那一刻终于到来了\\n7. 第七章 雪儿无法控制的性欲\\n8. 第八章 解开心结（上）\\n9. 第九章 解开心结（中）\\n10. 第十章 解开心结（下）\\n11. 第十一章 解开心结（终）\\n12. 第十二章 一些琐事\\n13. 第十三章 “玩”前的引子\\n14. 第十四章 第一次“玩”\\n15. 第十五章 疾风骤雨\\n16. 第十六章 雪儿失业\\n17. 第十七章 重回校园\\n18. 第十八章 夜总会（上）\\n19. 第十九章 夜总会（下）\\n20. 第二十章 节后那些天\\n\",\"wordCount\":\"144492\",\"author\":{\"@type\":\"Person\",\"name\":\"蓓蓓\",\"url\":\"https:\\/\\/crxs.me\\/fictions\\/keyword-蓓蓓.html\"}},\"articleBody\":\"我与老婆今天都25岁，是大学认识的，现在都供职在外企单位，生活质量很不错，但压力也蛮大。当时刚见到雪儿的时候我刚和初恋分手，在心灵最空虚的时候，这个乖巧可爱的女孩就蹦进我的生活。老婆属于那种娇小的小美女，羞涩迷人，一张洋娃娃般美丽、精致的小脸，天生一副楚楚可怜的摸样，但她却有着傲人的身材，1米60的身高才40多kg，丰满而盈润的两个乳房和翘翘的小屁股，让无数男人垂涎三尺，一双美腿和精致的小手小脚更是让人心醉。老婆从大学到工作，没少被骚扰过，在公车上经常被揩油，去ktv唱歌也会被大学的死党们一起占点便宜，最过分的一次毕业后和几个同事去郊区旅行，晚上老婆被灌醉后竟然玩起了打牌输了脱衣服的游戏，可怜\",\"wordCount\":3327,\"image\":\"https:\\/\\/upload.xchina.io\\/fiction\\/5fb6466e43a25.jpg\",\"author\":{\"@type\":\"Person\",\"name\":\"蓓蓓\",\"url\":\"https:\\/\\/crxs.me\\/fictions\\/keyword-蓓蓓.html\"}},{\"@context\":\"https:\\/\\/schema.org\",\"@type\":\"BreadcrumbList\",\"itemListElement\":[{\"@type\":\"ListItem\",\"position\":1,\"name\":\"首页\",\"item\":\"https:\\/\\/crxs.me\\/\"},{\"@type\":\"ListItem\",\"position\":2,\"name\":\"老婆雪儿的换妻经验\",\"item\":\"https:\\/\\/crxs.me\\/fiction\\/id-5fb6466e43a25.html\"},{\"@type\":\"ListItem\",\"position\":3,\"name\":\"第一章 一切的开始\",\"item\":\"https:\\/\\/crxs.me\"}]}]</script>\n" +
//                 "        <script>\n" +
//                 "        $(document).ready(function() {\n" +
//                 "            try {\n" +
//                 "                my.initToggleMenu();\n" +
//                 "            } catch (e) {}\n" +
//                 "        });\n" +
//                 "    </script>\n" +
//                 "                <script src=\"/scripts/ads.js?v=1.0.1\"></script>\n" +
//                 "        <script>\n" +
//                 "            window.addEventListener('DOMContentLoaded', () => {\n" +
//                 "                setTimeout(() => {\n" +
//                 "                    if (typeof Swal === 'undefined' || typeof window.googleAdsInstance === 'undefined') {\n" +
//                 "                        const modal_alert = new Modal();\n" +
//                 "                        modal_alert.setContent('<div class=\"modal-alert\">我们依靠广告维持运营，请关闭广告拦截插件，或将本站加入白名单，谢谢配合</div>').showModal();\n" +
//                 "                    }\n" +
//                 "                }, 1500);\n" +
//                 "            });\n" +
//                 "        </script>\n" +
//                 "    </head>\n" +
//                 "\n" +
//                 "<body>\n" +
//                 "    <nav class=\"mobile\">\n" +
//                 "    <div class=\"topMenu\">\n" +
//                 "        <div class=\"logo\">\n" +
//                 "            <a href=\"/\"><img src=\"/images/sites/logo/3.png?v=1.0.1\" alt=\"成人小说网\" /></a>\n" +
//                 "            <div class=\"country\">SG</div>\n" +
//                 "        </div>\n" +
//                 "        \n" +
//                 "        <div class=\"toggle-btn-container\"><i class=\"toggle-btn fas fa-bars\"></i></div>\n" +
//                 "    </div>\n" +
//                 "    <div class=\"overlay\"></div>\n" +
//                 "    <div class=\"toggle-bar\"><div>\n" +
//                 "        <i class=\"close-btn fas fa-xmark\"></i>\n" +
//                 "    </div>\n" +
//                 "    <div><a href=\"/\"><div class=\"menu\"><div><i class=\"fas fa-home\"></i> </div><div>首页</div></div></a><a href=\"/categories.html\"><div class=\"menu\"><div><i class=\"fas fa-sitemap\"></i> </div><div>分类</div></div></a><a href=\"/search.html\"><div class=\"menu\"><div><i class=\"fas fa-magnifying-glass\"></i> </div><div>站内搜索</div></div></a><div class=\"menu\"><div><i class=\"fas fa-xmark\"></i> </div><div>小黄书频道 <i class=\"fas fa-caret-down caret\"></i></div><div class=\"subs\"><a href=\"https://xchina.fit/videos.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-video\"></i>成人影片</div></a><a href=\"https://xchina.fit/photos.html\" target=\"_blank\" subid=\"13\"><div><i class=\"far fa-image\"></i>情色套图</div></a><a href=\"https://xchina.fit/fictions.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-book\"></i>成人小说</div></a><a href=\"https://xchina.fit/models.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-person-dress\"></i>模特/摄影师</div></a><a href=\"https://xchina.fit/comments.html\" target=\"_blank\" subid=\"13\"><div><i class=\"far fa-comment\"></i>色友评论</div></a><a href=\"https://xchina.fit/trend.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-chart-line\"></i>热门趋势</div></a><a href=\"https://xchina.fit/amateurs.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-camera\"></i>业余自拍</div></a></div></div><div class=\"menu\"><div><i class=\"fas fa-sitemap\"></i> </div><div>旗下站点 <i class=\"fas fa-caret-down caret\"></i></div><div class=\"subs\"><a href=\"https://1909.me\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/9.png\" alt=\"1909下载网\" />1909下载网</div></a><a href=\"https://litu100.xyz\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/14.png\" alt=\"丽图·污漫画\" />丽图·污漫画</div></a><a href=\"https://shise.me\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/11.png\" alt=\"视色\" />视色</div></a><a href=\"https://xchina.app\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/5.png\" alt=\"成人APP精选\" />成人APP精选</div></a><a href=\"https://sexgps.net\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/4.png\" alt=\"色情导航\" />色情导航</div></a><a href=\"https://javd.me\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/21.png\" alt=\"JAVD\" />JAVD</div></a><a href=\"https://seyeah.com\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/24.png\" alt=\"色也\" />色也</div></a></div></div><div class=\"menu\"><div><i class=\"fas fa-image\"></i> </div><div>联系我们 <i class=\"fas fa-caret-down caret\"></i></div><div class=\"subs\"><a href=\"https://xchina.fit/ad.html\" target=\"_blank\" subid=\"15\"><div><i class=\"fas fa-chart-line\"></i>广告服务</div></a><a href=\"https://xiaohuangshu.me\" target=\"_blank\" subid=\"15\"><div><i class=\"fas fa-link\"></i>网址发布页</div></a></div></div></div>\n" +
//                 "</nav>\n" +
//                 "<nav class=\"pc\">\n" +
//                 "    <div>\n" +
//                 "        <div class=\"logo\">\n" +
//                 "            <a href=\"/\"><img src=\"/images/sites/logo/3.png?v=1.0.1\" alt=\"成人小说网\" /></a>\n" +
//                 "            <div class=\"country\">SG</div>\n" +
//                 "        </div>\n" +
//                 "        <div class=\"topMenu\"><a href=\"/\"><div class=\"menu\"><div><i class=\"fas fa-home\"></i> </div><div>首页</div></div></a><a href=\"/categories.html\"><div class=\"menu\"><div><i class=\"fas fa-sitemap\"></i> </div><div>分类</div></div></a><a href=\"/search.html\"><div class=\"menu\"><div><i class=\"fas fa-magnifying-glass\"></i> </div><div>站内搜索</div></div></a><div class=\"menu\"><div><i class=\"fas fa-xmark\"></i> </div><div>小黄书频道 <i class=\"fas fa-caret-down caret\"></i></div><div class=\"subs\"><a href=\"https://xchina.fit/videos.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-video\"></i>成人影片</div></a><a href=\"https://xchina.fit/photos.html\" target=\"_blank\" subid=\"13\"><div><i class=\"far fa-image\"></i>情色套图</div></a><a href=\"https://xchina.fit/fictions.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-book\"></i>成人小说</div></a><a href=\"https://xchina.fit/models.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-person-dress\"></i>模特/摄影师</div></a><a href=\"https://xchina.fit/comments.html\" target=\"_blank\" subid=\"13\"><div><i class=\"far fa-comment\"></i>色友评论</div></a><a href=\"https://xchina.fit/trend.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-chart-line\"></i>热门趋势</div></a><a href=\"https://xchina.fit/amateurs.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-camera\"></i>业余自拍</div></a></div></div><div class=\"menu\"><div><i class=\"fas fa-sitemap\"></i> </div><div>旗下站点 <i class=\"fas fa-caret-down caret\"></i></div><div class=\"subs\"><a href=\"https://1909.me\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/9.png\" alt=\"1909下载网\" />1909下载网</div></a><a href=\"https://litu100.xyz\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/14.png\" alt=\"丽图·污漫画\" />丽图·污漫画</div></a><a href=\"https://shise.me\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/11.png\" alt=\"视色\" />视色</div></a><a href=\"https://xchina.app\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/5.png\" alt=\"成人APP精选\" />成人APP精选</div></a><a href=\"https://sexgps.net\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/4.png\" alt=\"色情导航\" />色情导航</div></a><a href=\"https://javd.me\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/21.png\" alt=\"JAVD\" />JAVD</div></a><a href=\"https://seyeah.com\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/24.png\" alt=\"色也\" />色也</div></a></div></div><div class=\"menu\"><div><i class=\"fas fa-image\"></i> </div><div>联系我们 <i class=\"fas fa-caret-down caret\"></i></div><div class=\"subs\"><a href=\"https://xchina.fit/ad.html\" target=\"_blank\" subid=\"15\"><div><i class=\"fas fa-chart-line\"></i>广告服务</div></a><a href=\"https://xiaohuangshu.me\" target=\"_blank\" subid=\"15\"><div><i class=\"fas fa-link\"></i>网址发布页</div></a></div></div></div>\n" +
//                 "        \n" +
//                 "        <div class=\"languages\"></div>\n" +
//                 "        <div class=\"login\"><div class=\"notLogined\"><a href=\"https://xchina.online/?s=1PeDzul39o_w_qN7-u97I0IveExGSjRkUFNKZ2lqUCtNQSsweE90OEk0dVlaWGZRcW1HdFRFdnkzeEtmSTdReGJyNkI0UDlRb0lsY1dTT3ZYZTYxajZFMVZBcjUzZjFjL0RXZmh0OFRDMlpxUFhXWXlId28yV2RvV2Iwakp3V0ltS2ZNV21oVS9DTzUvMFpC\" rel=\"nofollow\">登录 | 注册</a></div></div>\n" +
//                 "    </div>\n" +
//                 "</nav>        <div class=\"breadcrumb\"><div class=\"main-container\"><span class=\"breadcrumb-prefix\">\uD83D\uDCCD</span><span><a href=\"/\">首页</a><i class=\"fas fa-angles-right\"></i><a href=\"/fiction/id-5fb6466e43a25.html\">老婆雪儿的换妻经验</a><i class=\"fas fa-angles-right\"></i>第一章 一切的开始</span></div></div>    <a id=\"anchor-page-top\"></a>\n" +
//                 "    <div class=\"main-container\"><style>\n" +
//                 "    .fiction-body {\n" +
//                 "        font-size: 1rem;\n" +
//                 "    }\n" +
//                 "</style>\n" +
//                 "\n" +
//                 "<div class=\"layout-lr fiction\">\n" +
//                 "    <div class=\"left-1\">\n" +
//                 "        <div class=\"content-box\"><div class=\"fiction-cover-left\" style=\"background-image: url(https://upload.xchina.io/fiction/5fb6466e43a25.jpg);\" role=\"img\" aria-label=\"《老婆雪儿的换妻经验》作者：蓓蓓\"></div></div>        <script>\n" +
//                 "$(document).ready(function () {\n" +
//                 "    var $searchInput = $(\".sidebar-search-input\");\n" +
//                 "    var $searchBtn = $(\".sidebar-search-btn\");\n" +
//                 "    \n" +
//                 "    function performSearch() {\n" +
//                 "        var keyword = $searchInput.val().trim();\n" +
//                 "        keyword = keyword.replace(/[\\*\\\"\\\\?\\&<>]/g, \"\");\n" +
//                 "        keyword = keyword.replace(/\\s /g, \" \");\n" +
//                 "        \n" +
//                 "        if (keyword.length < 2) {\n" +
//                 "            my.error(\"请输入关键词（2字以上）\");\n" +
//                 "            $searchInput.focus();\n" +
//                 "            return false;\n" +
//                 "        }\n" +
//                 "        \n" +
//                 "        var url = \"/fictions/keyword-\"   encodeURIComponent(keyword)   \".html\";\n" +
//                 "        location.href = url;\n" +
//                 "        return true;\n" +
//                 "    }\n" +
//                 "    \n" +
//                 "    $searchInput.on(\"keypress\", function (event) {\n" +
//                 "        if (event.keyCode === 13 || event.which === 13) {\n" +
//                 "            event.preventDefault();\n" +
//                 "            performSearch();\n" +
//                 "        }\n" +
//                 "    });\n" +
//                 "    \n" +
//                 "    $searchBtn.on(\"click\", function (event) {\n" +
//                 "        event.preventDefault();\n" +
//                 "        performSearch();\n" +
//                 "    });\n" +
//                 "    \n" +
//                 "    $searchInput.on(\"focus\", function() {\n" +
//                 "        $(this).removeClass(\"error\");\n" +
//                 "    });\n" +
//                 "});\n" +
//                 "</script>\n" +
//                 "<div class=\"content-box sidebar-search\" role=\"search\">\n" +
//                 "    <div class=\"header\">小说搜索</div>\n" +
//                 "    <div class=\"search-input-wrapper\">\n" +
//                 "        <input class=\"sidebar-search-input\" type=\"text\" name=\"keyword\" value=\"\" placeholder=\"小说标题、作者\" maxlength=\"20\" autocomplete=\"off\" />\n" +
//                 "        <button type=\"button\" class=\"sidebar-search-btn\" title=\"搜索\">\n" +
//                 "            <i class=\"fas fa-magnifying-glass\"></i>\n" +
//                 "        </button>\n" +
//                 "    </div>\n" +
//                 "</div>        <div class=\"content-box series\"><h3>小说分类</h3><a href=\"/fictions/1.html\"><div class=\"sub checked\">全部成人小说 (18103)</div></a><a href=\"/fictions/tag-1.html\"><div class=\"sub\">人妻女友 (6495)</div></a><a href=\"/fictions/tag-101.html\"><div class=\"sub\">编辑推荐 (5991)</div></a><a href=\"/fictions/tag-102.html\"><div class=\"sub\">长篇连载 (5926)</div></a><a href=\"/fictions/tag-4.html\"><div class=\"sub\">都市生活 (5395)</div></a><a href=\"/fictions/tag-9.html\"><div class=\"sub\">家庭乱伦 (4690)</div></a><a href=\"/fictions/tag-10.html\"><div class=\"sub\">多人群交 (2720)</div></a><a href=\"/fictions/tag-13.html\"><div class=\"sub\">强暴性虐 (2545)</div></a><a href=\"/fictions/tag-8.html\"><div class=\"sub\">古典玄幻 (2192)</div></a><a href=\"/fictions/tag-2.html\"><div class=\"sub\">学生校园 (1805)</div></a><a href=\"/fictions/tag-16.html\"><div class=\"sub\">绿帽主题 (1794)</div></a><a href=\"/fictions/tag-11.html\"><div class=\"sub\">公司职场 (1404)</div></a><a href=\"/fictions/tag-7.html\"><div class=\"sub\">经验故事 (1204)</div></a><a href=\"/fictions/tag-12.html\"><div class=\"sub\">露出暴露 (993)</div></a><a href=\"/fictions/tag-999.html\"><div class=\"sub\">有声小说 (860)</div></a><a href=\"/fictions/tag-14.html\"><div class=\"sub\">西方主题 (550)</div></a><a href=\"/fictions/tag-5.html\"><div class=\"sub\">动漫游戏 (310)</div></a><a href=\"/fictions/tag-3.html\"><div class=\"sub\">伴侣交换 (281)</div></a><a href=\"/fictions/tag-15.html\"><div class=\"sub\">同性主题 (280)</div></a><a href=\"/fictions/tag-6.html\"><div class=\"sub\">名人明星 (160)</div></a><a href=\"/fictions/tag-103.html\"><div class=\"sub\">经典回忆 (109)</div></a><a href=\"/fictions/tag-99.html\"><div class=\"sub\">耽美小说 (21)</div></a><a href=\"/fictions/tag-998.html\"><div class=\"sub\">漫画小说 (4)</div></a><a href=\"/fictions/tag-1000.html\"><div class=\"sub\">色友发表 (38)</div></a></div>                <div class=\"content-box\"><div class=\"static-container-8\"><a href=\"https://xchina.app\" target=\"_blank\" clickmode=\"cpt\" clickid=\"157\" rel=\"nofollow noopener\"><div class=\"a-media zone-8\" style=\"background-image: url(https://upload.xchina.io/media/65f354c243fb6.webp);\"></div></a><a href=\"https://www.vps000.org/?code=E21C20\" target=\"_blank\" clickmode=\"cpt\" clickid=\"2\" rel=\"nofollow noopener\"><div class=\"a-media zone-8\" style=\"background-image: url(https://upload.xchina.io/media/65f35522cb457.webp);\"></div></a></div></div>    </div>\n" +
//                 "    <div class=\"right-5\">\n" +
//                 "        <div class=\"content-box\"><div class=\"static-container-4\"><a href=\"https://www.d8881.win/index.html\" target=\"_blank\" clickmode=\"cpt\" clickid=\"472\" rel=\"nofollow noopener\"><div class=\"a-media zone-4\" style=\"background-image: url(https://upload.xchina.io/media/69006d33f2f5d.webp);\"></div></a><a href=\"https://playbw88kt.com/caejwc\" target=\"_blank\" clickmode=\"cpt\" clickid=\"465\" rel=\"nofollow noopener\"><div class=\"a-media zone-4\" style=\"background-image: url(https://upload.xchina.io/media/68de37f628bf1.webp);\"></div></a><a href=\"https://playbw88kt.com/dvecwc\" target=\"_blank\" clickmode=\"cpt\" clickid=\"468\" rel=\"nofollow noopener\"><div class=\"a-media zone-4\" style=\"background-image: url(https://upload.xchina.io/media/68e6331f57b13.webp);\"></div></a><a href=\"https://hlw934.life/?a=ygzi87\" target=\"_blank\" clickmode=\"cpt\" clickid=\"462\" rel=\"nofollow noopener\"><div class=\"a-media zone-4\" style=\"background-image: url(https://upload.xchina.io/media/68dcf8ae91a9b.webp);\"></div></a><a href=\"https://tf4.juechentf.net/\" target=\"_blank\" clickmode=\"cpt\" clickid=\"457\" rel=\"nofollow noopener\"><div class=\"a-media zone-4\" style=\"background-image: url(https://upload.xchina.io/media/68db5e04ad48c.webp);\"></div></a><a href=\"https://playbw88kt.com/tehjwc\" target=\"_blank\" clickmode=\"cpt\" clickid=\"463\" rel=\"nofollow noopener\"><div class=\"a-media zone-4\" style=\"background-image: url(https://upload.xchina.io/media/68dd214f2ae5f.webp);\"></div></a><div class=\"a-media ex-728-90\"><script data-cfasync=\"false\" async type=\"text/javascript\" src=\"//ji.queachycorer.com/tpxnLfv9WzuQfBZ2/127694\"></script></div></div></div>        <div class=\"content-box fiction-controls\"><div class=\"font-size\"><div class=\"label\">字号：</div><div class=\"fiction-control-btn smaller\">A-</div><div class=\"fiction-control-btn larger\">A </div></div><div class=\"chapter-go\"><a href=\"/fiction/id-5fb6466e43a25.html\"><div class=\"fiction-control-btn prev\"><i class=\"fas fa-chevron-left\"></i>导览</div></a><a href=\"/fiction/id-dGhpc19pc19hX2ZpeGVkME1YUjJHSUZOUFUwcFpZbzRvTlVzZFE9PQ==.html\"><div class=\"fiction-control-btn next\">下一章<i class=\"fas fa-chevron-right\"></i></div></a></div></div>        <a id=\"top\"></a>\n" +
//                 "        <div class=\"content-box fiction-content\">\n" +
//                 "            <div class=\"title\">\n" +
//                 "                            </div>\n" +
//                 "                            <div class=\"tags\"><a href=\"/fictions/tag-1.html\"><div class=\"tag\">人妻女友</div></a><a href=\"/fictions/tag-3.html\"><div class=\"tag\">伴侣交换</div></a><a href=\"/fictions/tag-10.html\"><div class=\"tag\">多人群交</div></a><a href=\"/fictions/tag-12.html\"><div class=\"tag\">露出暴露</div></a><a href=\"/fictions/tag-16.html\"><div class=\"tag\">绿帽主题</div></a><a href=\"/fictions/tag-101.html\"><div class=\"tag\">编辑推荐</div></a><a href=\"/fictions/tag-102.html\"><div class=\"tag\">长篇连载</div></a></div>\n" +
//                 "                                        <div class=\"sub-title\">\n" +
//                 "                                            <div>\n" +
//                 "                            作者：<span>棒棒毛子</span>                        </div>\n" +
//                 "                                                                            </div>\n" +
//                 "                        <div class=\"chapter-title\">\n" +
//                 "                第一章 一切的开始            </div>\n" +
//                 "                                    <div class=\"fiction-body\">\n" +
//                 "                <p>我与老婆今天都25岁，是大学认识的，现在都供职在外企单位，生活质量很不错，但压力也蛮大。当时刚见到雪儿的时候我刚和初恋分手，在心灵最空虚的时候，这个乖巧可爱的女孩就蹦进我的生活。</p><p>老婆属于那种娇小的小美女，羞涩迷人，一张洋娃娃般美丽、精致的小脸，天生一副楚楚可怜的摸样，但她却有着傲人的身材，1米60的身高才40多kg，丰满而盈润的两个乳房和翘翘的小屁股，让无数男人垂涎三尺，一双美腿和精致的小手小脚更是让人心醉。</p><p>老婆从大学到工作，没少被骚扰过，在公车上经常被揩油，去ktv唱歌也会被大学的死党们一起占点便宜，最过分的一次毕业后和几个同事去郊区旅行，晚上老婆被灌醉后竟然玩起了打牌输了脱衣服的游戏，可怜老婆牌技太差，输的连内裤都被硬扯掉了，还让人亲了小屁股和小脚才肯放回自己的房间。那天之后老婆后悔了很长时间，而我每次想起当时的情景，就会立刻硬起来，兴奋异常。</p><p>后来上网看到许多评论才了解到长时间的平淡性生活总会疲倦，需要注入一点新鲜元素才能更加激情。其实老婆也有这样的想法，每次当我看成人图片或者电影时，她总也好奇地凑过来，小脸鼓鼓红红的搭在我肩膀上。后来还让我帮她申请成人论坛的帐号，趁我不在家的时候自己经常偷偷跑上去浏览。慢慢我了解到一些夫妻交换方面的事，看了很多经历者的评论，想象着自己娇小可爱的老婆被别人侵占揉捏的时候，就兴奋到了极点。</p><p>有天晚上在我们ooxx的时候，我向她说了交换的想法，没想到她极力反对，说这些只是网上捏造和想象，绝对不可能在现实生活中去尝试。我无奈草草射了，觉得完全提不起情绪了，老婆还是很关心的趴在我身上安慰我说：“大老公，也许将来有天可以按你的愿望实现呢。”慢慢老婆坐起来，用手拨开晶莹滴两片小肉片，把小密洞对着我的嘴。</p><p>尽管已经有3年的性生活，但可能一是因为我们做的次数比较少，二是因为我的能力很一般，勃起长度才12厘米长2点5厘米粗，抽插5分钟就要射的原因，老婆的小逼还是和第一次见一样鲜嫩，粉红色的小肉片在橙色的灯光下几乎透明，毛毛覆盖的面积很少，却很浓密，老婆的小洞洞和阴蒂更是异常敏感，每次干前只要稍微安抚一下，小洞洞里就充满了淫汁，我总喜欢让老婆分腿跪在床上，看着她的淫汁顺着两个小肉片滴下来……</p><p>我知道这是老婆又发骚了，这是我和老婆形成的习惯，每次我射后都喜欢帮她口交，她说每次当我帮她口交的时候能让她感到一种舒服的快感，尤其是舔她小豆豆的时候，老婆喜欢叫自己的阴蒂小豆豆，老婆很快就乱颤着喊饶命了，但她却从来不肯帮我口交，也不让我直接内射，想到这儿，我一边舔着老婆鲜嫩的鲍鱼，一边又开始计划如何让老婆能接受换妻这件事。</p><p>后来的几天我没再提出这件事，但每天和老婆ooxx的时候，都刻意地不给她口交，果然没过两天老婆就受不了了，小洞洞里的水水一天比一天流得多了起来。</p><p>一天回家，看到老婆只穿着一件围裙过来开门，小脸气鼓鼓地撅着，故意把小乳头露在围裙边缘，若隐若现地勾引人的视线。</p><p>我一口咬住老婆的小乳头，老婆连忙小声娇滴到：“老公别这样，门还没关呢，不要让别人看到啊……啊……不要咬……”（看精彩成人小说上《成人小说网》：https://crxs.me）</p>\n" +
//                 "<p>我用舌头刷着老婆的两个小乳头说：“想让老公吃的话，就让门开着。”</p><p>老婆无奈只能开着门让我在门口吃她的小乳头，其实我们都明白，这层只有我们一家住户，所以即使开着门也完全不用担心会被别人发现。但我还是幻想着老婆被别人偷窥的情形，不觉把手伸到了老婆没有穿小内裤小缝缝上。</p><p>“哇塞！老婆，今天怎么特别湿啊，好象都滴下来了啊。”</p><p>老婆连忙夹进了腿把我拉回了屋里，赖在怀里撒娇说：“都是老公不好，也不让人家爽爽，都好几天了，一想想就流好多水水。”</p><p>我的小弟弟早已经箭在弦上，但为了更长远的计划，必须忍……</p><p>“老婆，我还有点公事要处理，这样，你先去上会网，我忙完了一会就来陪你。”</p><p>老婆可爱的小脸都快哭了出来，夹紧了自己的腿坐到了电脑旁，哀怨的眼神看着我。</p><p>我生怕再被老婆可人的模样勾引住，慌忙溜进书房。老婆坐回电脑前，鼠标一晃，好啊，她自己在家居然在看成人论坛，怪不得刚才想成那样呢……我偷偷地望过去，发现老婆在看一个可爱小女孩子的性爱写真。还真别说，照片中的那个女孩还真有点像我可爱的老婆。</p><p>待了一会，老婆慢慢的把手伸进了两腿之间，轻轻滑动了起来，我装作看图纸，完全不理会她，老婆的动作慢慢大了一点，为了不发出声音闭紧了小嘴，挺挺的乳房上面，两个粉红色的小乳头翘了起来，从我对她平时的观察，知道她马上要“爽爽”了，果然，老婆轻轻地哼了一声整个身体趴到了电脑桌上……老婆以前从未在我面前手淫过，我看的也欲火高烧，自己打飞机射了出来。</p><p>第二天我到成人用品商店买了一根按摩棒，晚上回家爱爱的时候，又看见老婆只穿着小围裙坐在电脑旁看成人论坛。这次可不能放过骚骚的老婆了，抱起她娇小的身子一边吃着她高高翘起的小乳粒，一边把她按到床上。老婆羞涩地闭上眼睛，一只手拨开自己的阴户一只手拿着我的鸡巴在阴道口上摩擦。我用力一顶将阴茎一下全部插入老婆细嫩的小肉洞，老婆阴道流出大量的蜜汁都几乎被挤出来。</p><p>“老婆你是不是很骚啊？洞洞里这么多水，插一下都要流出来好多。”</p><p>“大坏老公……啊……快点插我……我是骚骚老婆……啊……老公……”</p><p>这么长时间没给过老婆，她今天果然特别敏感，每次插到深处，都会颤动一下。老婆洞洞里的小肉芽被淫汁泡的晶莹可人，把我的鸡巴弄的特别舒服，很快就让我有了想射的冲动。我赶忙把摩棒插上电，一边减弱了抽送速度，一边用按摩头对上老婆的小豆豆，老婆从没用过这样的东西，先是吃惊的睁大眼睛，马上就被电击了一样，发起嗲来：“老公你拿得是什么呀？啊……小豆豆好舒服……啊……不要停……老公插我……老公插我……”</p><p>老婆屁股扭动着好让我的鸡巴能更强烈的抽插，我感到她的小肉洞越来越紧里面的淫汁越来越多，每下抽送都能带出好多淫汁流到老婆性感的屁股上。</p>（<a href=\"https://xchina.app\" target=\"_blank\" style=\"color: #00c;\">成人APP精选（https://xchina.app），每款都经过站长人工审核</a>）<p>“啊……老公……再插快点……我要大鸡鸡……啊……”老婆洞洞里小肉芽强烈的按压我的鸡巴，这是我以前从未感受过的，很快便缴了枪。老婆还意由未尽地用小肉洞来回套弄着我已经软掉的鸡巴。</p><p>“老公……刚才你用的震动的是什么呀……放在小豆豆上好舒服啊，比老公的舌头舔还舒服……”</p><p>“那个是按摩棒，只要插上电就能震动，骚老婆刚才是不是很爽啊？”</p><p>“就是老公的时间太短了……哼，我看别人写的都能插半个多小时呢……”老婆赖在我的怀里撒娇地说。</p><p>“不可能的，哪能插这么长时间，肯定是在骗老婆，你说是谁能插半小时？让他来插插我的漂亮老婆，看能不能坚持住？”</p><p>“老公你好坏……我才不要别人插我呢，只要老公一个人的大鸡鸡。”</p><p>尽管老婆这么说，可我心想这第一步已经算是完成了。果然以后老婆自己在家的时候，经常偷偷地看着我给她下载的av片或者图片用按摩棒自慰。而在我们爱爱的时候，我也会让他幻想着按摩棒是另一个人的大鸡鸡要和老公一起欺负老婆。</p><p>老婆慢慢的习惯了按摩棒，每次做爱都必须要我和按摩棒一起抽插她的小嫩洞。因为按摩棒的震动和老婆的小洞洞里淫水、肉芽的刺激每次我射得都比以前快点，老婆每次在我射完后都会有点不开心，总是央求我下次时间再长点。</p><p>后来，我又给老婆申请了一个视频聊天帐号，老婆一开始害羞，只肯看看别的女孩怎么在聊天群里展现自己，看着其他狼友的大鸡鸡老婆的小洞洞也会变的很湿，一边看着其他大鸡鸡一边让我抽插她的小淫洞。</p><p>慢慢她偶尔开一下自己的视频，开始拘束得很，穿得厚厚的，一但有人关注她，就立刻下线跑掉，我鼓励老婆，告诉她她的身材是多么完美，而且又只用摄像头对着身体，完全没必要担心，这她才能放开一点，在聊天室的群狼里立刻成了焦点，主持人每次看她上线，都号召所有人一起看她的表演。</p><p>老婆很被动，但很乖，按着主持人的诱导，每次都会脱的一丝不挂，还要露出小肉洞给他们看。而每次视频之后老婆和我都是特别兴奋，我让她想象着我是不同的狼友正在干她，老婆一边点头，一边喊出和她视频聊天的人的那些名字，而老婆喊的这些人在视频上看起来鸡鸡都是特别大特别粗的那些。</p><p>这样持续了1个多月，当我偶尔提出想让老婆在现实里尝试一下和别人做爱时，老婆还是不答应，但没有一口回绝，只是说，网络上因为不认识，所以没关系，生活中都可能碰到，她接受不了。几次下来我也没了办法，老婆这么坚持，我想没什么希望了。</p>                <div class=\"fiction-chapter-navigator\"><a href=\"/fiction/id-5fb6466e43a25.html\"><div class=\"fiction-control-btn prev\"><i class=\"fas fa-chevron-left\"></i>导览</div></a><a href=\"/fiction/id-dGhpc19pc19hX2ZpeGVkME1YUjJHSUZOUFUwcFpZbzRvTlVzZFE9PQ==.html\"><div class=\"fiction-control-btn next\">下一章<i class=\"fas fa-chevron-right\"></i></div></a></div>            </div>\n" +
//                 "        </div>\n" +
//                 "                <a id=\"comment\"></a>\n" +
//                 "        \n" +
//                 "\n" +
//                 "<script>\n" +
//                 "    var commentOptions = {\"dataMode\":\"object\",\"dataObject\":{\"mode\":\"fiction\",\"id\":\"5fb6466e43a25\"},\"words\":{\"success\":\"操作成功\",\"reply\":\"回复\",\"view\":\"查看\",\"submitReply\":\"添加公开回复\",\"cancel\":\"取消\",\"hideReplies\":\"隐藏回复\",\"n_replies\":\"条回复\",\"n_floor\":\"楼\",\"no_record\":\"还没有人发表过评论\",\"no_record_my\":\"您还没有发表过评论\",\"translate\":\"翻译它\",\"translation\":\"翻译：\",\"translating\":\"翻译中\",\"translate_failed\":\"翻译失败\",\"comment_success\":\"评论发表成功\"},\"config\":{\"maxChar\":300,\"maxReplyLength\":300,\"selectors\":{\"dataContainer\":\".data\",\"pagerContainer\":\".pager-js\"},\"scrollAnchor\":\"#comment_start\",\"scrollOffset\":100,\"scrollDuration\":500}};\n" +
//                 "    var userInfo = {\"Nickname\":\"新加坡色友\",\"AvatarHtml\":\"<div class=\\\"avatar char s40\\\">新<\\/div>\"};\n" +
//                 "    var quickRepliesData = [\"这么好的帖，不推对不起自己啊\",\"由衷感謝大大精彩的分享 !\",\"楼主一生平安！（请狼友保持队形）…\",\"对楼主的敬意犹如滔滔流水连绵不绝，又如黄河泛滥一发而不可收\",\"真是生我者父母，知我者楼主呀！\",\"故事很精彩，看in了\",\"真是让人印象深刻的文章啊！\",\"小黄书里看黄书，零丁洋里叹零丁\",\"夕阳西下，断肠人在天涯\",\"这种真情实意的小黄文是没有一定的亲身体验写不出来的\",\"字里行间无不流露出作者身上无法隐藏的那股骚劲\",\"读书吧，它会使你的生活变得舒畅愉快  --高尔基\",\"救救孩子，让孩子本着自己的兴趣多读书吧  --不是鲁迅说的\",\"书是伟大淫才留给全人类的遗产 --也不是鲁迅说的\",\"读书使人头脑聪明  --伏尔泰\",\"这是一篇积极的催人泪下的小黄书，请带着健康的心理观看\",\"故事太诱惑人了，要是发生在我身上就好了\",\"写的真好，看的我也想去写小说了\",\"这不就是写的我老婆的故事吗？\",\"在我所有看过的小说里，该文属于最棒的1\\/n（n>=1000000）\",\"小说写的非常好，故事情节诱人，感情细腻而真实，作者一定是大师级的人物\",\"喂喂喂，有人吗？好像还没完结呢，抓紧写完呀，加油！\",\"刚看了个开头就把我吸引住了，收藏了慢慢看~\",\"文笔不错，就是剧情略感单薄\",\"写的很好，很真实\",\"贵在真实，值得一看\",\"给大大手动点赞\uD83D\uDC4D\",\"感谢大大分享！1024！\"];\n" +
//                 "</script>\n" +
//                 "\n" +
//                 "<script>\n" +
//                 "    var minChar = 4;\n" +
//                 "    var maxChar = 300;\n" +
//                 "\n" +
//                 "    $(document).ready(function() {\n" +
//                 "        var currentStarRating = 0;\n" +
//                 "\n" +
//                 "        function initStarRating() {\n" +
//                 "            $('.star-rating').each(function() {\n" +
//                 "                var $rating = $(this);\n" +
//                 "                var $labels = $rating.find('label');\n" +
//                 "\n" +
//                 "                $labels.on('mouseenter', function() {\n" +
//                 "                    var starId = $(this).attr('for');\n" +
//                 "                    var value = parseInt(starId.replace('star', ''));\n" +
//                 "                    showStars($rating, value, true);\n" +
//                 "                });\n" +
//                 "\n" +
//                 "                $rating.on('mouseleave', function() {\n" +
//                 "                    showStars($rating, currentStarRating, false);\n" +
//                 "                });\n" +
//                 "\n" +
//                 "                $labels.on('click', function() {\n" +
//                 "                    var starId = $(this).attr('for');\n" +
//                 "                    var value = parseInt(starId.replace('star', ''));\n" +
//                 "\n" +
//                 "                    if (currentStarRating === value) {\n" +
//                 "                        currentStarRating = 0;\n" +
//                 "                        $rating.find('input[type=\"radio\"]').prop('checked', false);\n" +
//                 "                    } else {\n" +
//                 "                        currentStarRating = value;\n" +
//                 "                        $('#'   starId).prop('checked', true);\n" +
//                 "                    }\n" +
//                 "\n" +
//                 "                    showStars($rating, currentStarRating, false);\n" +
//                 "                });\n" +
//                 "            });\n" +
//                 "        }\n" +
//                 "\n" +
//                 "        function showStars($rating, count, isHover) {\n" +
//                 "            var $labels = $rating.find('label');\n" +
//                 "\n" +
//                 "            $labels.removeClass('active hover-active');\n" +
//                 "\n" +
//                 "            for (var i = 1; i <= count; i  ) {\n" +
//                 "                var $label = $rating.find('label[for=\"star'   i   '\"]');\n" +
//                 "                if (isHover) {\n" +
//                 "                    $label.addClass('hover-active');\n" +
//                 "                } else {\n" +
//                 "                    $label.addClass('active');\n" +
//                 "                }\n" +
//                 "            }\n" +
//                 "        }\n" +
//                 "\n" +
//                 "        function getCurrentRating() {\n" +
//                 "            return currentStarRating;\n" +
//                 "        }\n" +
//                 "\n" +
//                 "        function setRating(rating) {\n" +
//                 "            currentStarRating = rating;\n" +
//                 "            var $rating = $('.star-rating');\n" +
//                 "            if (rating > 0) {\n" +
//                 "                $('#star'   rating).prop('checked', true);\n" +
//                 "            } else {\n" +
//                 "                $rating.find('input[type=\"radio\"]').prop('checked', false);\n" +
//                 "            }\n" +
//                 "            showStars($rating, currentStarRating, false);\n" +
//                 "        }\n" +
//                 "\n" +
//                 "        initStarRating();\n" +
//                 "\n" +
//                 "        $(\"a[name='submit-comment']\").click(function() {\n" +
//                 "            let $btn = $(this);\n" +
//                 "            if (!$btn.hasClass(\"disabled\")) {\n" +
//                 "                $btn.addClass(\"disabled\");\n" +
//                 "\n" +
//                 "                var scoreValue = $(\"input[type='radio'][name='score']:checked\").val();\n" +
//                 "\n" +
//                 "                my.ajax({\n" +
//                 "                    action: \"submitComment\",\n" +
//                 "                    objMode: commentOptions.dataObject.mode,\n" +
//                 "                    objId: commentOptions.dataObject.id,\n" +
//                 "                    content: $(\"textarea[name='comment']\").val().trim(),\n" +
//                 "                    country: $(\".quick-reply select[name='country']\").val(),\n" +
//                 "                    score: scoreValue\n" +
//                 "                }, function(result) {\n" +
//                 "                    $btn.removeClass(\"disabled\");\n" +
//                 "                    switch (result.code) {\n" +
//                 "                        case 0:\n" +
//                 "                            my.success(commentOptions.words.comment_success);\n" +
//                 "                            $(\"textarea[name='comment']\").val(\"\");\n" +
//                 "                            currentStarRating = 0;\n" +
//                 "                            $('.star-rating input[type=\"radio\"]').prop('checked', false);\n" +
//                 "                            showStars($('.star-rating'), 0, false);\n" +
//                 "                            commentManager.commentPage = 1;\n" +
//                 "                            commentManager.getComments();\n" +
//                 "                            break;\n" +
//                 "                        default:\n" +
//                 "                            my.error(result.message);\n" +
//                 "                            break;\n" +
//                 "                    }\n" +
//                 "                });\n" +
//                 "            }\n" +
//                 "        });\n" +
//                 "\n" +
//                 "        $(\".quick-reply-btn\").click(function() {\n" +
//                 "            showQuickReplyModal();\n" +
//                 "        });\n" +
//                 "\n" +
//                 "        $(\"textarea[name='comment']\").keyup(function() {\n" +
//                 "            var charCount = $(this).val().length;\n" +
//                 "            $(\".charCount\").text(charCount   \" / \"   maxChar);\n" +
//                 "        }).trigger(\"keyup\");\n" +
//                 "\n" +
//                 "        window.getCurrentRating = getCurrentRating;\n" +
//                 "        window.setRating = setRating;\n" +
//                 "    });\n" +
//                 "\n" +
//                 "    function showQuickReplyModal() {\n" +
//                 "        if (!quickRepliesData || Object.keys(quickRepliesData).length === 0) {\n" +
//                 "            return;\n" +
//                 "        }\n" +
//                 "\n" +
//                 "        var quickReplyListHtml = '<div class=\"quick-reply-list\">';\n" +
//                 "        for (var key in quickRepliesData) {\n" +
//                 "            var replyText = quickRepliesData[key];\n" +
//                 "            quickReplyListHtml  = '<div class=\"quick-reply-item\" data-reply=\"'   replyText.replace(/\"/g, '&quot;')   '\">';\n" +
//                 "            quickReplyListHtml  = '<div class=\"reply-text\">'   replyText   '</div>';\n" +
//                 "            quickReplyListHtml  = '</div>';\n" +
//                 "        }\n" +
//                 "        quickReplyListHtml  = '</div>';\n" +
//                 "\n" +
//                 "        quickReplyListHtml  = '<style>';\n" +
//                 "        quickReplyListHtml  = '.quick-reply-list { max-height: 400px; overflow-y: auto; }';\n" +
//                 "        quickReplyListHtml  = '.quick-reply-item { padding: 10px; border-bottom: 1px solid #eee; cursor: pointer; transition: background-color 0.2s; }';\n" +
//                 "        quickReplyListHtml  = '.quick-reply-item:hover { background-color: #f5f5f5; }';\n" +
//                 "        quickReplyListHtml  = '.quick-reply-item:last-child { border-bottom: none; }';\n" +
//                 "        quickReplyListHtml  = '.reply-text { line-height: 1.4; }';\n" +
//                 "        quickReplyListHtml  = '</style>';\n" +
//                 "\n" +
//                 "        var modal = new Modal({\n" +
//                 "            threeSection: true,\n" +
//                 "            headerText: \"快捷回复\",\n" +
//                 "            showDefaultCloseButton: true,\n" +
//                 "            showHeaderCloseButton: true,\n" +
//                 "            backdropClose: true,\n" +
//                 "            escClose: true\n" +
//                 "        });\n" +
//                 "\n" +
//                 "        modal.setContent(quickReplyListHtml).showModal();\n" +
//                 "\n" +
//                 "        setTimeout(function() {\n" +
//                 "            $('.quick-reply-item').click(function() {\n" +
//                 "                var replyText = $(this).data('reply');\n" +
//                 "                $(\"textarea[name='comment']\").val(replyText).trigger('keyup');\n" +
//                 "                modal.closeModal();\n" +
//                 "            });\n" +
//                 "        }, 100);\n" +
//                 "    }\n" +
//                 "</script>\n" +
//                 "\n" +
//                 "<a id=\"anchor-comment\"></a>\n" +
//                 "<div class=\"content-box comments\">\n" +
//                 "    <div class=\"header\">\n" +
//                 "        <div class=\"title-lr\">\n" +
//                 "            <div class=\"left\">\n" +
//                 "                色友点评                (1)            </div>\n" +
//                 "        </div>\n" +
//                 "    </div>\n" +
//                 "    <div class=\"layout-lr\">\n" +
//                 "        <div class=\"left-fixed-50\">\n" +
//                 "            <div class=\"user-avatar\">\n" +
//                 "                <div class=\"avatar char s40\">新</div>            </div>\n" +
//                 "        </div>\n" +
//                 "        <div>\n" +
//                 "            <div class=\"submit-comment\">\n" +
//                 "                <div class=\"submit\">\n" +
//                 "                                            <div class=\"quick-reply\">\n" +
//                 "                            <button type='button' class='btn comment-dot smaller quick-reply-btn'>快捷回复</button>                                                    </div>\n" +
//                 "                                        <div class=\"textarea-container\">\n" +
//                 "                        <textarea name=\"comment\" placeholder=\"无需注册就能点评，试试吧\"></textarea>\n" +
//                 "                    </div>\n" +
//                 "                                            <div class=\"rating\">\n" +
//                 "                            <div class=\"submit-score star-rating\">\n" +
//                 "                                <input type=\"radio\" name=\"score\" id=\"star1\" value=\"1\" />\n" +
//                 "                                <label for=\"star1\"></label>\n" +
//                 "                                <input type=\"radio\" name=\"score\" id=\"star2\" value=\"2\" />\n" +
//                 "                                <label for=\"star2\"></label>\n" +
//                 "                                <input type=\"radio\" name=\"score\" id=\"star3\" value=\"3\" />\n" +
//                 "                                <label for=\"star3\"></label>\n" +
//                 "                                <input type=\"radio\" name=\"score\" id=\"star4\" value=\"4\" />\n" +
//                 "                                <label for=\"star4\"></label>\n" +
//                 "                                <input type=\"radio\" name=\"score\" id=\"star5\" value=\"5\" />\n" +
//                 "                                <label for=\"star5\"></label>\n" +
//                 "                            </div>\n" +
//                 "                        </div>\n" +
//                 "                                        <div class=\"button-line\">\n" +
//                 "                        <span class=\"charCount\"></span>\n" +
//                 "                        <a name=\"submit-comment\" class=\"btn yes button-submit-comment\">发表评论</a>\n" +
//                 "                    </div>\n" +
//                 "                                            <div class=\"rules\">\n" +
//                 "                            <ul>\n" +
//                 "                                                                    <li>\n" +
//                 "                                        任何人都可以发表评论，注册用户会显示昵称，未注册用户会显示所在国家；                                    </li>\n" +
//                 "                                                                                                    <li>\n" +
//                 "                                        本站崇尚言论自由，我们不设审查，但对以下情况零容忍，违反者会受到封号乃至封禁 IP 的处罚：                                        <ul>\n" +
//                 "                                            <li>\n" +
//                 "                                                发广告（任何出现他站网址或引导进入他站的都会被视为广告）；                                            </li>\n" +
//                 "                                            <li>\n" +
//                 "                                                暴力、仇恨或歧视言论；                                            </li>\n" +
//                 "                                                                                        <li>\n" +
//                 "                                                无意义的灌水；                                            </li>\n" +
//                 "                                            <li>\n" +
//                 "                                                同一主题请以回复方式发表在一篇评论中，禁止发表多个评论影响其他色友阅读；                                            </li>\n" +
//                 "                                                                                            <li>\n" +
//                 "                                                    <a href=\"/blog/id-677ba804c2777.html\">收起戾气，文明讨论；</a>\n" +
//                 "                                                </li>\n" +
//                 "                                                                                    </ul>\n" +
//                 "                                    </li>\n" +
//                 "                                                                                            </ul>\n" +
//                 "                        </div>\n" +
//                 "                                    </div>\n" +
//                 "            </div>\n" +
//                 "        </div>\n" +
//                 "    </div>\n" +
//                 "    <div>\n" +
//                 "        <a id=\"comment_start\"></a>\n" +
//                 "        <div class=\"pager-js\"></div>\n" +
//                 "        <div class=\"data\"></div>\n" +
//                 "        <div class=\"pager-js\"></div>\n" +
//                 "    </div>\n" +
//                 "</div>        <div class=\"content-box\"><div class=\"static-container-5\"><a href=\"https://xchina.app\" target=\"_blank\" clickmode=\"cpt\" clickid=\"151\" rel=\"nofollow noopener\"><div class=\"a-media zone-5\" style=\"background-image: url(https://upload.xchina.io/media/65fe05db43ce8.webp);\"></div></a><a href=\"http://154.17.22.56/lvd?channel=xhs-bottom2\" target=\"_blank\" clickmode=\"cpt\" clickid=\"442\" rel=\"nofollow noopener\"><div class=\"a-media zone-5\" style=\"background-image: url(https://upload.xchina.io/media/6890054f5fe9b.webp);\"></div></a></div></div>        <div class=\"banner-sexgps\"><div><div><a href=\"https://sexgps.net\" target=\"_blank\" title=\"色情导航收集了各类优质成人色情资源，如：成人网站、成人视频、成人APP、成人漫画、成人小说、成人下载等，让你一次撸个够…\">色情导航：</a></div><div><a href=\"https://sexgps.net/site.html?id=6865053a4d4ad\" target=\"_blank\" title=\"蓝猫vpn - 2025 看片神器 (送谷歌和飞机账号)\">蓝猫vpn</a></div><div><a href=\"https://sexgps.net/site.html?id=684d441f3d5c4\" target=\"_blank\" title=\"小小妹中学门 - 福建兄妹，紫色面具，事件门，大开眼界\">小小妹中学门</a></div><div><a href=\"https://sexgps.net/site.html?id=669c9c7067019\" target=\"_blank\" title=\"中国嫖娼地图 - 中国最全最便宜的招嫖信息\">中国嫖娼地图</a></div><div><a href=\"https://sexgps.net/site.html?id=675fd51669f69\" target=\"_blank\" title=\"蓝莓VPN - VPN性价王，免费试用，3元会员\">蓝莓VPN</a></div><div><a href=\"https://sexgps.net/site.html?id=67fd2b24e5d76\" target=\"_blank\" title=\"吃瓜69 - 炸裂吃瓜網紅明星私密爆料\">吃瓜69</a></div><div><a href=\"https://sexgps.net/site.html?id=686d87b843b0a\" target=\"_blank\" title=\"稀缺精品 - 收集各种稀缺猎奇合集\">稀缺精品</a></div><div><a href=\"https://sexgps.net/site.html?id=687cf93768bb5\" target=\"_blank\" title=\"澳门金沙赌场 - 澳门金沙赌场注册即送18元\">澳门金沙赌场</a></div><div><a href=\"https://sexgps.net/site.html?id=68df866734e8c\" target=\"_blank\" title=\"3D性爱游戏 - 全网最全性爱游戏\">3D性爱游戏</a></div><div><a href=\"https://sexgps.net/site.html?id=68c7d2df63478\" target=\"_blank\" title=\"小萝莉户外露出 - 大尺度人前露出\">小萝莉户外露出</a></div><div><a href=\"https://sexgps.net/site.html?id=673dd9cd09637\" target=\"_blank\" title=\"吃瓜爆料网 - 成人免费爆料网，明星/高官/白领/教师\">吃瓜爆料网</a></div><div><a href=\"https://sexgps.net/site.html?id=68ed21ed72993\" target=\"_blank\" title=\"麻豆头条吃瓜 - 全网吃瓜黑料头条 | 明星网红爆料\">麻豆头条吃瓜</a></div><div><a href=\"https://sexgps.net/site.html?id=67a2bd43d4195\" target=\"_blank\" title=\"创世直播 - 每一秒都是现场，每一刻都是传奇\">创世直播</a></div><div><a href=\"https://sexgps.net/site.html?id=68fcb04304278\" target=\"_blank\" title=\"小黄鸟 - 黄推福利姬探花内容平台 | 推特视频下载\">小黄鸟</a></div><div><a href=\"https://sexgps.net/site.html?id=686b6d42bc964\" target=\"_blank\" title=\"U体育 - 亚洲第一体育平台\">U体育</a></div><div><a href=\"https://sexgps.net/site.html?id=683a0732b2659\" target=\"_blank\" title=\"AI在线性爱游戏 - 千万种性爱场景，自由交互\">AI在线性爱游戏</a></div><div><a href=\"https://sexgps.net/site.html?id=68f375ec9173b\" target=\"_blank\" title=\"百万爆料视频 - 汇集全网爆料视频\">百万爆料视频</a></div><div><a href=\"https://sexgps.net/site.html?id=6852b18b2983c\" target=\"_blank\" title=\"全球最强抖音成人版 - 一站满足全部欲望\">全球最强抖音成人版</a></div><div><a href=\"https://sexgps.net/site.html?id=67eaaa20068ae\" target=\"_blank\" title=\"AI去衣黑科技 - 秒去衣|AI去衣黑科技\">AI去衣黑科技</a></div><div><a href=\"https://sexgps.net/site.html?id=678e43a921150\" target=\"_blank\" title=\"女厕偷拍  裙底偷拍 - 酒店破解摄像头直播\">女厕偷拍  裙底偷拍</a></div><div><a href=\"https://sexgps.net/site.html?id=68fcf5932da3a\" target=\"_blank\" title=\"佳妮俱乐部 - 全网最强高端约会、商务模特、外围、福利姬\">佳妮俱乐部</a></div><div><a href=\"https://sexgps.net/site.html?id=68f8abca1eaf5\" target=\"_blank\" title=\"黑料网 - 每日更新网红明星黑料吃瓜爆料\">黑料网</a></div><div><a href=\"https://sexgps.net/site.html?id=681e3e5d43406\" target=\"_blank\" title=\"仅限新加坡_是您网 - 新加坡最好的小姐姐网站\">仅限新加坡_是您网</a></div><div><a href=\"https://sexgps.net/site.html?id=681128e06bacb\" target=\"_blank\" title=\"萝莉岛 - 萝莉岛事件揭秘、暗网资源、网红爆料、抖音网红吃瓜\">萝莉岛</a></div><div><a href=\"https://sexgps.net/site.html?id=6818f71219aba\" target=\"_blank\" title=\"AI风月 - 全球最大中文无限制AI色情\">AI风月</a></div><div><a href=\"https://sexgps.net/site.html?id=68de64a2d7b1c\" target=\"_blank\" title=\"人妻日记 - 万部免费视频  成人在线观看\">人妻日记</a></div><div><a href=\"https://sexgps.net/site.html?id=68e5704a21c1c\" target=\"_blank\" title=\"5x5x影院 - 热门黑料,免费在线观看,每天更新300部\">5x5x影院</a></div><div><a href=\"https://sexgps.net/site.html?id=673dd9cf17fdc\" target=\"_blank\" title=\"黑料百科 - 成人免费爆料网，明星/高官/白领/教师\">黑料百科</a></div><div><a href=\"https://sexgps.net/site.html?id=6597201626c89\" target=\"_blank\" title=\"秀人网 - 秀人网及旗下品牌全集，提供打包下载\">秀人网</a></div><div><a href=\"https://sexgps.net/site.html?id=654be17a39a53\" target=\"_blank\" title=\"H動漫網 - 免費的線上看成人色情卡通片\">H動漫網</a></div><div><a href=\"https://sexgps.net/site.html?id=65e30e218d775\" target=\"_blank\" title=\"疯情书库 - 辣文小黄文高h小说在线阅读\">疯情书库</a></div><div><a href=\"https://sexgps.net/site.html?id=654be00c22e2f\" target=\"_blank\" title=\"色花堂 - 老牌中文成人论坛\">色花堂</a></div><div><a href=\"https://sexgps.net/site.html?id=654bd168d8235\" target=\"_blank\" title=\"Redtube - 世界最大的色情网站之一！\">Redtube</a></div><div><a href=\"https://sexgps.net/site.html?id=654c7f060bc4f\" target=\"_blank\" title=\"套图学院 - 国模写真及私拍套图\">套图学院</a></div><div><a href=\"https://sexgps.net/site.html?id=686b815a1d4cf\" target=\"_blank\" title=\"JavSB\">JavSB</a></div><div><a href=\"https://sexgps.net/site.html?id=65ad74daa2a80\" target=\"_blank\" title=\"新美图录 - 收集整理各类美女图片\">新美图录</a></div><div><a href=\"https://sexgps.net/site.html?id=65e8bc78170b8\" target=\"_blank\" title=\"酷18 - 综合性成人论坛\">酷18</a></div><div><a href=\"https://sexgps.net/site.html?id=654bda27bae0b\" target=\"_blank\" title=\"街拍第一站 - 街头拍摄良家美女\">街拍第一站</a></div><div><a href=\"https://sexgps.net/site.html?id=654be126a02f5\" target=\"_blank\" title=\"H動漫 - H動漫/裏番/線上看\">H動漫</a></div><div><a href=\"https://sexgps.net/site.html?id=654be31f9826a\" target=\"_blank\" title=\"九妖漫画网 - 优质韩漫、日漫、每日更新\">九妖漫画网</a></div><div><a href=\"https://sexgps.net/site.html?id=65ff189fce2f4\" target=\"_blank\" title=\"好视角图片网 - 各个角度欣赏女人的美\">好视角图片网</a></div><div><a href=\"https://sexgps.net/site.html?id=65dbabb936fa1\" target=\"_blank\" title=\"Youavhub - 免費日本AV高清影片\">Youavhub</a></div><div><a href=\"https://sexgps.net/site.html?id=6594040799504\" target=\"_blank\" title=\"艾薇福利社 - 丝袜写真|美女美图\">艾薇福利社</a></div><div><a href=\"https://sexgps.net/site.html?id=6550eea5e3433\" target=\"_blank\" title=\"夜色王朝 - 综合性中文成人论坛\">夜色王朝</a></div><div><a href=\"https://sexgps.net/site.html?id=654ca52ba3aaf\" target=\"_blank\" title=\"南  South Plus - 综合性成人网站，需要注册才能浏览\">南  South Plus</a></div><div><a href=\"https://sexgps.net/site.html?id=654bde6eea9cc\" target=\"_blank\" title=\"丽图·污漫画 - 免费看韩国/日本的色情漫画和H漫画\">丽图·污漫画</a></div><div><a href=\"https://sexgps.net/site.html?id=654bcf5fed2bb\" target=\"_blank\" title=\"JAVDAY.TV - 免費高清AV在線看\">JAVDAY.TV</a></div><div><a href=\"https://sexgps.net/site.html?id=6550d88a6508c\" target=\"_blank\" title=\"Metarthunter.com - 欧美成人图片在线看\">Metarthunter.com</a></div><div><a href=\"https://sexgps.net/site.html?id=654bd93b08164\" target=\"_blank\" title=\"中国原创 - 在线中文、日本AV\">中国原创</a></div><div><a href=\"https://sexgps.net/site.html?id=65c51cd949daf\" target=\"_blank\" title=\"柠檬皮美女资讯站 - 会员制美女图片站\">柠檬皮美女资讯站</a></div><div><a href=\"https://sexgps.net/site.html?id=65bc100497fb3\" target=\"_blank\" title=\"美图鉴赏 - Coser写真图片\">美图鉴赏</a></div></div></div>    </div>\n" +
//                 "</div>\n" +
//                 "\n" +
//                 "<script>\n" +
//                 "    $(function() {\n" +
//                 "        var fontSizes = [\"0.8\",\"0.9\",\"1\",\"1.1\",\"1.2\",\"1.3\",\"1.4\",\"1.5\"];\n" +
//                 "        var $body = $(\".fiction-body\");\n" +
//                 "        var $smaller = $(\".fiction-control-btn.smaller\");\n" +
//                 "        var $larger = $(\".fiction-control-btn.larger\");\n" +
//                 "        var cookieKey = \"__fiction_font-size\";\n" +
//                 "        var curIndex = fontSizes.indexOf(\"1\");\n" +
//                 "\n" +
//                 "        function updateFont() {\n" +
//                 "            $body.css(\"font-size\", fontSizes[curIndex]   \"rem\");\n" +
//                 "            my.setCookie(cookieKey, fontSizes[curIndex]);\n" +
//                 "            $smaller.toggleClass(\"disabled\", curIndex === 0);\n" +
//                 "            $larger.toggleClass(\"disabled\", curIndex === fontSizes.length - 1);\n" +
//                 "        }\n" +
//                 "        $smaller.click(function() {\n" +
//                 "            if (curIndex > 0) {\n" +
//                 "                curIndex--;\n" +
//                 "                updateFont();\n" +
//                 "            }\n" +
//                 "        });\n" +
//                 "        $larger.click(function() {\n" +
//                 "            if (curIndex < fontSizes.length - 1) {\n" +
//                 "                curIndex  ;\n" +
//                 "                updateFont();\n" +
//                 "            }\n" +
//                 "        });\n" +
//                 "    });\n" +
//                 "</script></div>\n" +
//                 "\n" +
//                 "\n" +
//                 "\n" +
//                 "<footer class=\"mobile\"><a href=\"/\"><div class=\"menu-item\"><div><i class=\"fas fa-home\"></i></div><div>首页</div></div></a><a href=\"/search.html\"><div class=\"menu-item\"><div><i class=\"fas fa-magnifying-glass\"></i></div><div>搜索</div></div></a><a href=\"javascript: share();\"><div class=\"menu-item\"><div><i class=\"fas fa-share\"></i></div><div>分享</div></div></a><a href=\"javascript: toggleFav();\"><div class=\"menu-item fav\"><div><i class=\"far fa-heart\"></i></div><div>收藏</div></div></a><a href=\"/my.html\"><div class=\"menu-item\"><div><i class=\"far fa-user\"></i></div><div>我的</div></div></a></footer><script>\n" +
//                 "var share = function () {\n" +
//                 "    const shareModal = new Modal({\n" +
//                 "        threeSection: false,\n" +
//                 "        showDefaultCloseButton: true,\n" +
//                 "        escClose: true,\n" +
//                 "        backdropClose: true\n" +
//                 "    });\n" +
//                 "\n" +
//                 "    const shareContent = `\n" +
//                 "        <div class=\"modal-share\">\n" +
//                 "            <div>\n" +
//                 "                <img class=\"qrcode\" src=\"/images/empty.png\" />\n" +
//                 "            </div>\n" +
//                 "            <div>\n" +
//                 "                当前网址二维码\n" +
//                 "            </div>\n" +
//                 "            <div>\n" +
//                 "                <a name=\"BtnCopy\" class=\"btn btn-clone\" copyvalue=\"https://crxs.me/fiction.php\" copycaption=\"已复制\">\n" +
//                 "                    <i class=\"fas fa-clone\"></i> 复制当前网址\n" +
//                 "                </a>\n" +
//                 "            </div>\n" +
//                 "        </div>\n" +
//                 "    `;\n" +
//                 "\n" +
//                 "    shareModal.setContent(shareContent).showModal();\n" +
//                 "    my.initCopy();\n" +
//                 "    \n" +
//                 "    const qrcodeImg = shareModal.modalElement.querySelector('.qrcode');\n" +
//                 "    if (qrcodeImg && !qrcodeImg.getAttribute('loaded')) {\n" +
//                 "        qrcodeImg.setAttribute('loaded', 'true');\n" +
//                 "        qrcodeImg.src = \"/qrcode.php?url=https://crxs.me/fiction.php\";\n" +
//                 "    }\n" +
//                 "};\n" +
//                 "</script><footer class=\"pc\"><div><div>Copyright © 2025 成人小说网</div></div><div><div class=\"links\"><div>友情链接：</div><a clickmode=\"link\" clickid=\"1231\" href=\"https://xchina.app\" target=\"_blank\" rel=\"nofollow\">成人APP精选</a> | <a clickmode=\"link\" clickid=\"1319\" href=\"https://seyeah.com\" target=\"_blank\">色也·搜你想看</a></div><div class=\"exchange\"> | <a href=\"https://xchina.fit/ad.html\" target=\"_blank\">广告服务</a></div></div></div></footer><script>let visitUrl = 'https://v2.6888.site/v2.html?s=x8tB2fAorHSiJxwBf0F4L1RWbWo2RWhLSmF2dGxZOCt5UVBtWWZOVm1URng4andRVWx6U3YyVmxpK083ek9sVmFUOFNzcThlblI1RHcrTlJkOHNudHdUV0E2bzdpb2tUaXptQ09pKzN3aC9NRGtBTk5MdlhzaTZkNzNvK0xWUWpxbUhNbUtJemlRajVOUzJPemFqaHp6NHFJRlhYcmthbTEzU3F3SDhtVVM0cTdNcmorMTV4Rm1XUnVhc09NRVhjRVRsWUhLb0JLSW01V0NzeW5iTVFoREIyN2NsdGpPQVlCY2FoZ25DTXNtamZXaFVWMG1mNVZEYjQ4OFN6VjZ5aW16cmFlL0k1YmtqcENLTVF6am9Td2syVXBkbnV1SEdyTnJ0L2lJa3Y1czZQdm1oNFhnZ2hPVzNvMzhaQ0lYZDFQeFQ3ekRNN1RnUmZZMklO';let script = document.createElement('script');script.src = visitUrl   (visitUrl.includes('?') ? '&' : '?')   'nocache=' new Date().getTime();document.head.appendChild(script);</script><div class=\"floating-toolbar\"><div class=\"btn-group\"><a class=\"anchor\" href=\"#anchor-page-top\"><div class=\"floating-btn anchor-top\"><i class=\"fas fa-angle-double-up\"></i></div></a></div><div class=\"btn-group\"><div class=\"floating-btn favorite disabled\"><i class=\"far fa-heart\" title=\"请先登录\"></i></div><script>\n" +
//                 "$(document).ready(function() {\n" +
//                 "    $(\".floating-btn.favorite\").click(function() {\n" +
//                 "        let btn = $(this);\n" +
//                 "        if (btn.hasClass(\"disabled\")) return;\n" +
//                 "        if (btn.hasClass(\"doing\")) return;\n" +
//                 "        btn.addClass(\"doing\");\n" +
//                 "        my.ajax({\n" +
//                 "            action: \"toggleFavorite\",\n" +
//                 "            objMode: \"fiction\",\n" +
//                 "            objId: \"5fb6466e43a25\"\n" +
//                 "        }, function (result) {\n" +
//                 "            btn.removeClass(\"doing\");\n" +
//                 "            if (result.favorited) {\n" +
//                 "                btn.addClass(\"checked\");\n" +
//                 "                btn.find(\"i\").removeClass(\"far\").addClass(\"fas\");\n" +
//                 "            } else {\n" +
//                 "                btn.removeClass(\"checked\");\n" +
//                 "                btn.find(\"i\").removeClass(\"fas\").addClass(\"far\");\n" +
//                 "            }\n" +
//                 "        }, false, true);\n" +
//                 "    });\n" +
//                 "});\n" +
//                 "</script></div><div class=\"btn-group\"><a class=\"anchor\" href=\"#anchor-comment\"><div class=\"floating-btn anchor-comment\"><i class=\"far fa-comments\"></i></div></a></div><div class=\"btn-group\"><a href=\"/fiction/id-5fb6466e43a25.html\"><div data-href=\"/fiction/id-5fb6466e43a25.html\" class=\"floating-btn nav-prev\"><i class=\"fas fa-chevron-left\"></i></div></a><a href=\"/fiction/id-dGhpc19pc19hX2ZpeGVkME1YUjJHSUZOUFUwcFpZbzRvTlVzZFE9PQ==.html\"><div data-href=\"/fiction/id-dGhpc19pc19hX2ZpeGVkME1YUjJHSUZOUFUwcFpZbzRvTlVzZFE9PQ==.html\" class=\"floating-btn nav-next\"><i class=\"fas fa-chevron-right\"></i></div></a><script>\n" +
//                 "$(document).on(\"keydown\", function(event) {\n" +
//                 "    const key = event.key;\n" +
//                 "    if (key !== \"ArrowLeft\" && key !== \"ArrowRight\") return;\n" +
//                 "    const target = event.target;\n" +
//                 "    const tagName = target.tagName.toLowerCase();\n" +
//                 "    if ([\"input\", \"textarea\", \"select\"].includes(tagName)) return;\n" +
//                 "    if (target.contentEditable === 'true' || target.isContentEditable) return;\n" +
//                 "    if ($(\".lg-img-wrap\").is(\":visible\")) return;\n" +
//                 "    let btn;\n" +
//                 "    if (key === \"ArrowLeft\") {\n" +
//                 "        btn = $(\".floating-btn.nav-prev\");\n" +
//                 "    } else if (key === \"ArrowRight\") {\n" +
//                 "        btn = $(\".floating-btn.nav-next\");\n" +
//                 "    }\n" +
//                 "    if (btn) {\n" +
//                 "        btn.addClass(\"hover\");\n" +
//                 "        setTimeout(function() {\n" +
//                 "            let url = btn.data(\"href\");\n" +
//                 "            if (url != undefined) {\n" +
//                 "                if (!url.includes('#')) url  = '#anchor-page-top';\n" +
//                 "                window.location.href = url;\n" +
//                 "            }\n" +
//                 "        }, 120);\n" +
//                 "        event.preventDefault();\n" +
//                 "    }\n" +
//                 "});\n" +
//                 "</script></div></div><script>\n" +
//                 "$(function () {\n" +
//                 "    $('.floating-toolbar a.anchor').click(function(e) {\n" +
//                 "        let target = $(this).attr('href');\n" +
//                 "        if (target && target.startsWith('#')) {\n" +
//                 "            let el = $(target);\n" +
//                 "            if (el.length) {\n" +
//                 "                    e.preventDefault();\n" +
//                 "                    let navHeight = $('nav.pc').outerHeight() || 0;\n" +
//                 "                    let top = el.offset().top - navHeight;\n" +
//                 "                    $('html, body').animate({\n" +
//                 "                        scrollTop: top\n" +
//                 "                    }, 500);\n" +
//                 "                }\n" +
//                 "            }\n" +
//                 "        });\n" +
//                 "    });\n" +
//                 "</script>\n" +
//                 "<script>(function(){function c(){var b=a.contentDocument||a.contentWindow.document;if(b){var d=b.createElement('script');d.innerHTML=\"window.__CF$cv$params={r:'997166b2e9773d9e',t:'MTc2MTg5NTM0NQ=='};var a=document.createElement('script');a.src='/cdn-cgi/challenge-platform/scripts/jsd/main.js';document.getElementsByTagName('head')[0].appendChild(a);\";b.getElementsByTagName('head')[0].appendChild(d)}}if(document.body){var a=document.createElement('iframe');a.height=1;a.width=1;a.style.position='absolute';a.style.top=0;a.style.left=0;a.style.border='none';a.style.visibility='hidden';document.body.appendChild(a);if('loading'!==document.readyState)c();else if(window.addEventListener)document.addEventListener('DOMContentLoaded',c);else{var e=document.onreadystatechange||function(){};document.onreadystatechange=function(b){e(b);'loading'!==document.readyState&&(document.onreadystatechange=e,c())}}}})();</script></body>\n" +
//                 "</html>";
//     }
//
//     private static String h2() {
//         return "\n" +
//                 "<!DOCTYPE html>\n" +
//                 "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"zh-Hans\">\n" +
//                 "\n" +
//                 "<head>\n" +
//                 "        <meta name=\"renderer\" content=\"webkit\" />\n" +
//                 "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
//                 "    <link rel=\"icon\" type=\"image/png\" href=\"/images/sites/favicon/3.png?v=1.0.1\" />\n" +
//                 "    <meta name=\"keywords\" content=\"老婆雪儿的换妻经验,蓓蓓,\" />\n" +
//                 "    <meta name=\"description\" content=\"我与老婆今天都25岁，是大学认识的，现在都供职在外企单位，生活质量很不错，但压力也蛮大。当时刚见到雪儿的时候我刚和初恋分手，在心灵最空虚的时候，这个乖巧可爱的女孩就蹦进我的生活。老婆属于那种娇小的小美女，羞涩迷人，一张洋娃娃般美丽、精致的小脸，天生一副楚楚可怜的摸样，但她却有着傲人的身材，1米60的身高才40多kg，丰满而盈润的两个乳房和翘翘的小屁股，让无数男人垂涎三尺，一双美腿和精致的小手小脚更是让人心醉。\" />\n" +
//                 "    <title>第一章 一切的开始 - 老婆雪儿的换妻经验 - 成人小说网</title>\n" +
//                 "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\">\n" +
//                 "    <meta name=\"RATING\" content=\"RTA-5042-1996-1400-1577-RTA\" />\n" +
//                 "    <meta name=\"rating\" content=\"adult\" />\n" +
//                 "    <meta name=\"twitter:card\" content=\"summary_large_image\" />\n" +
//                 "    <meta name=\"twitter:title\" content=\"第一章 一切的开始 - 老婆雪儿的换妻经验\" />\n" +
//                 "    <meta name=\"twitter:description\" content=\"我与老婆今天都25岁，是大学认识的，现在都供职在外企单位，生活质量很不错，但压力也蛮大。当时刚见到雪儿的时候我刚和初恋分手，在心灵最空虚的时候，这个乖巧可爱的女孩就蹦进我的生活。老婆属于那种娇小的小美女，羞涩迷人，一张洋娃娃般美丽、精致的小脸，天生一副楚楚可怜的摸样，但她却有着傲人的身材，1米60的身高才40多kg，丰满而盈润的两个乳房和翘翘的小屁股，让无数男人垂涎三尺，一双美腿和精致的小手小脚更是让人心醉。\" />\n" +
//                 "    <meta name=\"twitter:image\" content=\"https://upload.xchina.io/fiction/5fb6466e43a25.jpg\" />\n" +
//                 "    <meta property=\"og:site_name\" content=\"成人小说网\" />\n" +
//                 "    <meta property=\"og:type\" content=\"website\" />\n" +
//                 "    <meta property=\"og:url\" content=\"https://crxs.me/fiction/id-5fb6466e43a25.html\" />\n" +
//                 "    <meta property=\"og:title\" content=\"第一章 一切的开始 - 老婆雪儿的换妻经验\" />\n" +
//                 "    <meta property=\"og:description\" content=\"我与老婆今天都25岁，是大学认识的，现在都供职在外企单位，生活质量很不错，但压力也蛮大。当时刚见到雪儿的时候我刚和初恋分手，在心灵最空虚的时候，这个乖巧可爱的女孩就蹦进我的生活。老婆属于那种娇小的小美女，羞涩迷人，一张洋娃娃般美丽、精致的小脸，天生一副楚楚可怜的摸样，但她却有着傲人的身材，1米60的身高才40多kg，丰满而盈润的两个乳房和翘翘的小屁股，让无数男人垂涎三尺，一双美腿和精致的小手小脚更是让人心醉。\" />\n" +
//                 "    <meta property=\"og:image\" content=\"https://upload.xchina.io/fiction/5fb6466e43a25.jpg\" />\n" +
//                 "        <meta name=\"referrer\" content=\"always\" />\n" +
//                 "    <link rel=\"stylesheet\" href=\"/plugins/fontawesome-free-6.7.2-web/css/all.min.css\" />\n" +
//                 "            <link rel=\"stylesheet\" href=\"/css/dst/main.min.css?v=1.1.14\" />\n" +
//                 "                            <link rel=\"stylesheet\" href=\"/extra/extra.css?v=1.0.1\" />\n" +
//                 "                <script src=\"/scripts/jquery-3.5.1.min.js\"></script>\n" +
//                 "    <script src=\"/scripts/jquery.blockUI.min.js\"></script>\n" +
//                 "    <script src=\"/scripts/modal/modal.js?v=1.0.5\"></script>\n" +
//                 "    <script src=\"/plugins/sweetAlert2/sweetalert2.all.min.js\"></script>\n" +
//                 "    <script src=\"/scripts/push.js?v=1.0.2\"></script>\n" +
//                 "    <script src=\"/scripts/my.js?v=1.0.3\"></script>\n" +
//                 "    <script src=\"/scripts/comment.js?v=1.0.12\"></script>\n" +
//                 "    <link rel=\"stylesheet\" href=\"/css/avatars/avatar.css?v=1.0.16\">    <link rel=\"canonical\" href=\"https://crxs.me/fiction/id-5fb6466e43a25.html\" />\n" +
//                 "        <meta http-equiv=\"content-language\" content=\"zh-Hans\" />\n" +
//                 "    <meta http-equiv=\"Delegate-CH\" content=\"Sec-CH-UA https://s.magsrv.com; Sec-CH-UA-Mobile https://s.magsrv.com; Sec-CH-UA-Arch https://s.magsrv.com; Sec-CH-UA-Model https://s.magsrv.com; Sec-CH-UA-Platform https://s.magsrv.com; Sec-CH-UA-Platform-Version https://s.magsrv.com; Sec-CH-UA-Bitness https://s.magsrv.com; Sec-CH-UA-Full-Version-List https://s.magsrv.com; Sec-CH-UA-Full-Version https://s.magsrv.com;\" />\n" +
//                 "        <div class=\"push-top-container\"><div class=\"push-top\" key=\"clicked_cpt_429\" clickmode=\"cpt\" clickid=\"429\" url=\"https://platform.usz88.com/sz/index8.html\"><div class=\"media\" style=\"background-image: url(https://upload.xchina.io/media/686cd9151dca4.webp);\"></div><div class=\"close\"><i class=\"fas fa-xmark\"></i></div></div><div class=\"push-top\" key=\"clicked_cpt_438\" clickmode=\"cpt\" clickid=\"438\" url=\"https://k7ba8p.jnkh.cn/13173e00/f5ea47.html?shareName=xbook\"><div class=\"media\" style=\"background-image: url(https://upload.xchina.io/media/68a1ce2c895ae.webp);\"></div><div class=\"close\"><i class=\"fas fa-xmark\"></i></div></div><div class=\"push-top\" key=\"clicked_cpt_461\" clickmode=\"cpt\" clickid=\"461\" url=\"https://hlw934.life/?a=ygzi87\"><div class=\"media\" style=\"background-image: url(https://upload.xchina.io/media/68dcf82e84cf8.webp);\"></div><div class=\"close\"><i class=\"fas fa-xmark\"></i></div></div><div class=\"push-top\" key=\"clicked_cpt_458\" clickmode=\"cpt\" clickid=\"458\" url=\"https://luoli.sbs\"><div class=\"media\" style=\"background-image: url(https://upload.xchina.io/media/68db9c9025e40.webp);\"></div><div class=\"close\"><i class=\"fas fa-xmark\"></i></div></div></div><div class=\"push-slider\" key=\"clicked_cpt_464\" clickmode=\"cpt\" clickid=\"464\" url=\"https://hlw934.life/?a=ygzi87\"><div class=\"media\"><video class=\"vid\" preload=\"metadata\" muted autoplay><source src=\"https://upload.xchina.io/media/68dd29ad98a0e.mp4\" type=\"video/mp4\" /></video></div><div class=\"close\">关闭</div></div><div class=\"push-slider\" key=\"clicked_cpt_427\" clickmode=\"cpt\" clickid=\"427\" url=\"https://longfenga.top/?xchina3\"><div class=\"media\"><video class=\"vid\" preload=\"metadata\" muted autoplay><source src=\"https://upload.xchina.io/media/686a4f879f37e.mp4\" type=\"video/mp4\" /></video></div><div class=\"close\">关闭</div></div><div class=\"push-bottom-container\" key=\"clicked_cpt_422\" clickmode=\"cpt\" clickid=\"422\" url=\"https://www.lanmao18.top/?code=6qQCDVHN\"><div class=\"push-bottom\"><div class=\"close\">关闭</div><div class=\"media\"><img src=\"https://upload.xchina.io/media/68650218b4246.webp\" /></div></div></div>            <script>\n" +
//                 "    let __user;\n" +
//                 "    try {\n" +
//                 "        var tmpStr = my.getCookie(\"__login_user\");\n" +
//                 "        __user = tmpStr ? JSON.parse(tmpStr) : undefined;\n" +
//                 "    } catch (e) {\n" +
//                 "        __user = undefined;\n" +
//                 "    }\n" +
//                 "    $(document).ready(function () {\n" +
//                 "        try {\n" +
//                 "            my.initCopy(\"当前网址已复制\");\n" +
//                 "        } catch (e) {}\n" +
//                 "    });\n" +
//                 "</script><script>\n" +
//                 "    var favOptions = {\"enabled\":true,\"objMode\":\"fiction\",\"objId\":\"5fb6466e43a25\",\"isFaved\":false};\n" +
//                 "    var showFav = function() {\n" +
//                 "        if (favOptions.enabled) {\n" +
//                 "            if (favOptions.isFaved) {\n" +
//                 "                $(\"footer .menu-item.fav\").addClass(\"isFaved\");\n" +
//                 "                $(\"footer .menu-item.fav i\").removeClass(\"far\").addClass(\"fas\");\n" +
//                 "            } else {\n" +
//                 "                $(\"footer .menu-item.fav\").removeClass(\"isFaved\");\n" +
//                 "                $(\"footer .menu-item.fav i\").removeClass(\"fas\").addClass(\"far\");\n" +
//                 "            }\n" +
//                 "        }\n" +
//                 "    };\n" +
//                 "    var toggleFav = function () {\n" +
//                 "        if (favOptions.enabled) {\n" +
//                 "            if (!__user) {\n" +
//                 "                my.confirm(\"需要登录才能使用收藏功能，前去登录吗？\", function () {\n" +
//                 "                    location.href = \"https://xchina.online/?s=Tp1J366op4ksV_JyKdXxWVpGSnpDdENCS3RpMzdkUmFMK1VGcDRuZWxXUE1oN0crT09qeXVwWXp0cXRWWEtmaEhLOTBaOG9RalFjaVB1ZG1lYWp1N0JnQk1mckJJUVZZaTcxUFJVZUhzbXNsaGdsc3UvL2NJVHRXL05YSXpOTWIvcnFxd1ZtSFFGYVlKS1c0\";\n" +
//                 "                });\n" +
//                 "            } else {\n" +
//                 "                my.ajax({\n" +
//                 "                    action: \"toggleFavorite\",\n" +
//                 "                    objMode: favOptions.objMode,\n" +
//                 "                    objId: favOptions.objId\n" +
//                 "                }, function (result) {\n" +
//                 "                    switch (result.code) {\n" +
//                 "                        case 0:\n" +
//                 "                            favOptions.isFaved = result.favorited;\n" +
//                 "                            showFav();\n" +
//                 "                            if (typeof __showFav === 'function') {__showFav(result.favorited);};\n" +
//                 "                            my.success(favOptions.isFaved ? \"已加入收藏\" : \"已取消收藏\");\n" +
//                 "                            break;\n" +
//                 "                        default:\n" +
//                 "                            my.error(result.message);\n" +
//                 "                            break;\n" +
//                 "                    }\n" +
//                 "                });\n" +
//                 "            }\n" +
//                 "        }\n" +
//                 "    };\n" +
//                 "</script>    \n" +
//                 "<script type=\"application/ld json\">[{\"@context\":\"https:\\/\\/schema.org\",\"@type\":\"Article\",\"headline\":\"第一章 一切的开始\",\"datePublished\":\"2020-11-19T18:18:22 08:00\",\"dateModified\":\"2020-11-19T18:18:22 08:00\",\"description\":\"老婆雪儿的换妻经验 - 第一章 一切的开始\",\"url\":\"https:\\/\\/crxs.me\\/fiction\\/id-dGhpc19pc19hX2ZpeGVkMDMveGliUWtDUUVTU0N1VC9FcW95MlE9PQ==.html\",\"mainEntityOfPage\":\"https:\\/\\/crxs.me\\/fiction\\/id-dGhpc19pc19hX2ZpeGVkMDMveGliUWtDUUVTU0N1VC9FcW95MlE9PQ==.html\",\"inLanguage\":\"zh-Hans\",\"publisher\":{\"@type\":\"Organization\",\"name\":\"成人小说网\",\"url\":\"https:\\/\\/crxs.me\"},\"isPartOf\":{\"@context\":\"https:\\/\\/schema.org\",\"@type\":\"Article\",\"headline\":\"老婆雪儿的换妻经验\",\"datePublished\":\"2020-11-19T18:18:22 08:00\",\"dateModified\":\"2020-11-19T18:18:22 08:00\",\"description\":\"我与老婆今天都25岁，是大学认识的，现在都供职在外企单位，生活质量很不错，但压力也蛮大。当时刚见到雪儿的时候我刚和初恋分手，在心灵最空虚的时候，这个乖巧可爱的女孩就蹦进我的生活。老婆属于那种娇小的小美女，羞涩迷人，一张洋娃娃般美丽、精致的小脸，天生一副楚楚可怜的摸样，但她却有着傲人的身材，1米60的身高才40多kg，丰\",\"image\":\"https:\\/\\/upload.xchina.io\\/fiction\\/5fb6466e43a25.jpg\",\"url\":\"https:\\/\\/crxs.me\\/fiction\\/id-5fb6466e43a25.html\",\"mainEntityOfPage\":\"https:\\/\\/crxs.me\\/fiction\\/id-5fb6466e43a25.html\",\"inLanguage\":\"zh-Hans\",\"publisher\":{\"@type\":\"Organization\",\"name\":\"成人小说网\",\"url\":\"https:\\/\\/crxs.me\"},\"keywords\":\"1,3,10,12,16,101,102\",\"articleBody\":\"目录：\\n1. 第一章 一切的开始\\n2. 第二章 多年好友带来的转折\\n3. 第三章 最后的准备\\n4. 第四章 挖掘老婆的淫荡本质\\n5. 第五章 酒店春色\\n6. 第六章 那一刻终于到来了\\n7. 第七章 雪儿无法控制的性欲\\n8. 第八章 解开心结（上）\\n9. 第九章 解开心结（中）\\n10. 第十章 解开心结（下）\\n11. 第十一章 解开心结（终）\\n12. 第十二章 一些琐事\\n13. 第十三章 “玩”前的引子\\n14. 第十四章 第一次“玩”\\n15. 第十五章 疾风骤雨\\n16. 第十六章 雪儿失业\\n17. 第十七章 重回校园\\n18. 第十八章 夜总会（上）\\n19. 第十九章 夜总会（下）\\n20. 第二十章 节后那些天\\n\",\"wordCount\":\"144492\",\"author\":{\"@type\":\"Person\",\"name\":\"蓓蓓\",\"url\":\"https:\\/\\/crxs.me\\/fictions\\/keyword-蓓蓓.html\"}},\"articleBody\":\"我与老婆今天都25岁，是大学认识的，现在都供职在外企单位，生活质量很不错，但压力也蛮大。当时刚见到雪儿的时候我刚和初恋分手，在心灵最空虚的时候，这个乖巧可爱的女孩就蹦进我的生活。老婆属于那种娇小的小美女，羞涩迷人，一张洋娃娃般美丽、精致的小脸，天生一副楚楚可怜的摸样，但她却有着傲人的身材，1米60的身高才40多kg，丰满而盈润的两个乳房和翘翘的小屁股，让无数男人垂涎三尺，一双美腿和精致的小手小脚更是让人心醉。老婆从大学到工作，没少被骚扰过，在公车上经常被揩油，去ktv唱歌也会被大学的死党们一起占点便宜，最过分的一次毕业后和几个同事去郊区旅行，晚上老婆被灌醉后竟然玩起了打牌输了脱衣服的游戏，可怜\",\"wordCount\":3327,\"image\":\"https:\\/\\/upload.xchina.io\\/fiction\\/5fb6466e43a25.jpg\",\"author\":{\"@type\":\"Person\",\"name\":\"蓓蓓\",\"url\":\"https:\\/\\/crxs.me\\/fictions\\/keyword-蓓蓓.html\"}},{\"@context\":\"https:\\/\\/schema.org\",\"@type\":\"BreadcrumbList\",\"itemListElement\":[{\"@type\":\"ListItem\",\"position\":1,\"name\":\"首页\",\"item\":\"https:\\/\\/crxs.me\\/\"},{\"@type\":\"ListItem\",\"position\":2,\"name\":\"老婆雪儿的换妻经验\",\"item\":\"https:\\/\\/crxs.me\\/fiction\\/id-5fb6466e43a25.html\"},{\"@type\":\"ListItem\",\"position\":3,\"name\":\"第一章 一切的开始\",\"item\":\"https:\\/\\/crxs.me\"}]}]</script>\n" +
//                 "        <script>\n" +
//                 "        $(document).ready(function() {\n" +
//                 "            try {\n" +
//                 "                my.initToggleMenu();\n" +
//                 "            } catch (e) {}\n" +
//                 "        });\n" +
//                 "    </script>\n" +
//                 "                <script src=\"/scripts/ads.js?v=1.0.1\"></script>\n" +
//                 "        <script>\n" +
//                 "            window.addEventListener('DOMContentLoaded', () => {\n" +
//                 "                setTimeout(() => {\n" +
//                 "                    if (typeof Swal === 'undefined' || typeof window.googleAdsInstance === 'undefined') {\n" +
//                 "                        const modal_alert = new Modal();\n" +
//                 "                        modal_alert.setContent('<div class=\"modal-alert\">我们依靠广告维持运营，请关闭广告拦截插件，或将本站加入白名单，谢谢配合</div>').showModal();\n" +
//                 "                    }\n" +
//                 "                }, 1500);\n" +
//                 "            });\n" +
//                 "        </script>\n" +
//                 "    </head>\n" +
//                 "\n" +
//                 "<body>\n" +
//                 "    <nav class=\"mobile\">\n" +
//                 "    <div class=\"topMenu\">\n" +
//                 "        <div class=\"logo\">\n" +
//                 "            <a href=\"/\"><img src=\"/images/sites/logo/3.png?v=1.0.1\" alt=\"成人小说网\" /></a>\n" +
//                 "            <div class=\"country\">SG</div>\n" +
//                 "        </div>\n" +
//                 "        \n" +
//                 "        <div class=\"toggle-btn-container\"><i class=\"toggle-btn fas fa-bars\"></i></div>\n" +
//                 "    </div>\n" +
//                 "    <div class=\"overlay\"></div>\n" +
//                 "    <div class=\"toggle-bar\"><div>\n" +
//                 "        <i class=\"close-btn fas fa-xmark\"></i>\n" +
//                 "    </div>\n" +
//                 "    <div><a href=\"/\"><div class=\"menu\"><div><i class=\"fas fa-home\"></i> </div><div>首页</div></div></a><a href=\"/categories.html\"><div class=\"menu\"><div><i class=\"fas fa-sitemap\"></i> </div><div>分类</div></div></a><a href=\"/search.html\"><div class=\"menu\"><div><i class=\"fas fa-magnifying-glass\"></i> </div><div>站内搜索</div></div></a><div class=\"menu\"><div><i class=\"fas fa-xmark\"></i> </div><div>小黄书频道 <i class=\"fas fa-caret-down caret\"></i></div><div class=\"subs\"><a href=\"https://xchina.fit/videos.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-video\"></i>成人影片</div></a><a href=\"https://xchina.fit/photos.html\" target=\"_blank\" subid=\"13\"><div><i class=\"far fa-image\"></i>情色套图</div></a><a href=\"https://xchina.fit/fictions.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-book\"></i>成人小说</div></a><a href=\"https://xchina.fit/models.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-person-dress\"></i>模特/摄影师</div></a><a href=\"https://xchina.fit/comments.html\" target=\"_blank\" subid=\"13\"><div><i class=\"far fa-comment\"></i>色友评论</div></a><a href=\"https://xchina.fit/trend.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-chart-line\"></i>热门趋势</div></a><a href=\"https://xchina.fit/amateurs.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-camera\"></i>业余自拍</div></a></div></div><div class=\"menu\"><div><i class=\"fas fa-sitemap\"></i> </div><div>旗下站点 <i class=\"fas fa-caret-down caret\"></i></div><div class=\"subs\"><a href=\"https://1909.me\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/9.png\" alt=\"1909下载网\" />1909下载网</div></a><a href=\"https://litu100.xyz\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/14.png\" alt=\"丽图·污漫画\" />丽图·污漫画</div></a><a href=\"https://shise.me\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/11.png\" alt=\"视色\" />视色</div></a><a href=\"https://xchina.app\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/5.png\" alt=\"成人APP精选\" />成人APP精选</div></a><a href=\"https://sexgps.net\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/4.png\" alt=\"色情导航\" />色情导航</div></a><a href=\"https://javd.me\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/21.png\" alt=\"JAVD\" />JAVD</div></a><a href=\"https://seyeah.com\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/24.png\" alt=\"色也\" />色也</div></a></div></div><div class=\"menu\"><div><i class=\"fas fa-image\"></i> </div><div>联系我们 <i class=\"fas fa-caret-down caret\"></i></div><div class=\"subs\"><a href=\"https://xchina.fit/ad.html\" target=\"_blank\" subid=\"15\"><div><i class=\"fas fa-chart-line\"></i>广告服务</div></a><a href=\"https://xiaohuangshu.me\" target=\"_blank\" subid=\"15\"><div><i class=\"fas fa-link\"></i>网址发布页</div></a></div></div></div>\n" +
//                 "</nav>\n" +
//                 "<nav class=\"pc\">\n" +
//                 "    <div>\n" +
//                 "        <div class=\"logo\">\n" +
//                 "            <a href=\"/\"><img src=\"/images/sites/logo/3.png?v=1.0.1\" alt=\"成人小说网\" /></a>\n" +
//                 "            <div class=\"country\">SG</div>\n" +
//                 "        </div>\n" +
//                 "        <div class=\"topMenu\"><a href=\"/\"><div class=\"menu\"><div><i class=\"fas fa-home\"></i> </div><div>首页</div></div></a><a href=\"/categories.html\"><div class=\"menu\"><div><i class=\"fas fa-sitemap\"></i> </div><div>分类</div></div></a><a href=\"/search.html\"><div class=\"menu\"><div><i class=\"fas fa-magnifying-glass\"></i> </div><div>站内搜索</div></div></a><div class=\"menu\"><div><i class=\"fas fa-xmark\"></i> </div><div>小黄书频道 <i class=\"fas fa-caret-down caret\"></i></div><div class=\"subs\"><a href=\"https://xchina.fit/videos.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-video\"></i>成人影片</div></a><a href=\"https://xchina.fit/photos.html\" target=\"_blank\" subid=\"13\"><div><i class=\"far fa-image\"></i>情色套图</div></a><a href=\"https://xchina.fit/fictions.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-book\"></i>成人小说</div></a><a href=\"https://xchina.fit/models.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-person-dress\"></i>模特/摄影师</div></a><a href=\"https://xchina.fit/comments.html\" target=\"_blank\" subid=\"13\"><div><i class=\"far fa-comment\"></i>色友评论</div></a><a href=\"https://xchina.fit/trend.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-chart-line\"></i>热门趋势</div></a><a href=\"https://xchina.fit/amateurs.html\" target=\"_blank\" subid=\"13\"><div><i class=\"fas fa-camera\"></i>业余自拍</div></a></div></div><div class=\"menu\"><div><i class=\"fas fa-sitemap\"></i> </div><div>旗下站点 <i class=\"fas fa-caret-down caret\"></i></div><div class=\"subs\"><a href=\"https://1909.me\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/9.png\" alt=\"1909下载网\" />1909下载网</div></a><a href=\"https://litu100.xyz\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/14.png\" alt=\"丽图·污漫画\" />丽图·污漫画</div></a><a href=\"https://shise.me\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/11.png\" alt=\"视色\" />视色</div></a><a href=\"https://xchina.app\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/5.png\" alt=\"成人APP精选\" />成人APP精选</div></a><a href=\"https://sexgps.net\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/4.png\" alt=\"色情导航\" />色情导航</div></a><a href=\"https://javd.me\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/21.png\" alt=\"JAVD\" />JAVD</div></a><a href=\"https://seyeah.com\" target=\"_blank\" subid=\"14\"><div><img src=\"/images/sites/24.png\" alt=\"色也\" />色也</div></a></div></div><div class=\"menu\"><div><i class=\"fas fa-image\"></i> </div><div>联系我们 <i class=\"fas fa-caret-down caret\"></i></div><div class=\"subs\"><a href=\"https://xchina.fit/ad.html\" target=\"_blank\" subid=\"15\"><div><i class=\"fas fa-chart-line\"></i>广告服务</div></a><a href=\"https://xiaohuangshu.me\" target=\"_blank\" subid=\"15\"><div><i class=\"fas fa-link\"></i>网址发布页</div></a></div></div></div>\n" +
//                 "        \n" +
//                 "        <div class=\"languages\"></div>\n" +
//                 "        <div class=\"login\"><div class=\"notLogined\"><a href=\"https://xchina.online/?s=1PeDzul39o_w_qN7-u97I0IveExGSjRkUFNKZ2lqUCtNQSsweE90OEk0dVlaWGZRcW1HdFRFdnkzeEtmSTdReGJyNkI0UDlRb0lsY1dTT3ZYZTYxajZFMVZBcjUzZjFjL0RXZmh0OFRDMlpxUFhXWXlId28yV2RvV2Iwakp3V0ltS2ZNV21oVS9DTzUvMFpC\" rel=\"nofollow\">登录 | 注册</a></div></div>\n" +
//                 "    </div>\n" +
//                 "</nav>        <div class=\"breadcrumb\"><div class=\"main-container\"><span class=\"breadcrumb-prefix\">\uD83D\uDCCD</span><span><a href=\"/\">首页</a><i class=\"fas fa-angles-right\"></i><a href=\"/fiction/id-5fb6466e43a25.html\">老婆雪儿的换妻经验</a><i class=\"fas fa-angles-right\"></i>第一章 一切的开始</span></div></div>    <a id=\"anchor-page-top\"></a>\n" +
//                 "    <div class=\"main-container\"><style>\n" +
//                 "    .fiction-body {\n" +
//                 "        font-size: 1rem;\n" +
//                 "    }\n" +
//                 "</style>\n" +
//                 "\n" +
//                 "<div class=\"layout-lr fiction\">\n" +
//                 "    <div class=\"left-1\">\n" +
//                 "        <div class=\"content-box\"><div class=\"fiction-cover-left\" style=\"background-image: url(https://upload.xchina.io/fiction/5fb6466e43a25.jpg);\" role=\"img\" aria-label=\"《老婆雪儿的换妻经验》作者：蓓蓓\"></div></div>        <script>\n" +
//                 "$(document).ready(function () {\n" +
//                 "    var $searchInput = $(\".sidebar-search-input\");\n" +
//                 "    var $searchBtn = $(\".sidebar-search-btn\");\n" +
//                 "    \n" +
//                 "    function performSearch() {\n" +
//                 "        var keyword = $searchInput.val().trim();\n" +
//                 "        keyword = keyword.replace(/[\\*\\\"\\\\?\\&<>]/g, \"\");\n" +
//                 "        keyword = keyword.replace(/\\s /g, \" \");\n" +
//                 "        \n" +
//                 "        if (keyword.length < 2) {\n" +
//                 "            my.error(\"请输入关键词（2字以上）\");\n" +
//                 "            $searchInput.focus();\n" +
//                 "            return false;\n" +
//                 "        }\n" +
//                 "        \n" +
//                 "        var url = \"/fictions/keyword-\"   encodeURIComponent(keyword)   \".html\";\n" +
//                 "        location.href = url;\n" +
//                 "        return true;\n" +
//                 "    }\n" +
//                 "    \n" +
//                 "    $searchInput.on(\"keypress\", function (event) {\n" +
//                 "        if (event.keyCode === 13 || event.which === 13) {\n" +
//                 "            event.preventDefault();\n" +
//                 "            performSearch();\n" +
//                 "        }\n" +
//                 "    });\n" +
//                 "    \n" +
//                 "    $searchBtn.on(\"click\", function (event) {\n" +
//                 "        event.preventDefault();\n" +
//                 "        performSearch();\n" +
//                 "    });\n" +
//                 "    \n" +
//                 "    $searchInput.on(\"focus\", function() {\n" +
//                 "        $(this).removeClass(\"error\");\n" +
//                 "    });\n" +
//                 "});\n" +
//                 "</script>\n" +
//                 "<div class=\"content-box sidebar-search\" role=\"search\">\n" +
//                 "    <div class=\"header\">小说搜索</div>\n" +
//                 "    <div class=\"search-input-wrapper\">\n" +
//                 "        <input class=\"sidebar-search-input\" type=\"text\" name=\"keyword\" value=\"\" placeholder=\"小说标题、作者\" maxlength=\"20\" autocomplete=\"off\" />\n" +
//                 "        <button type=\"button\" class=\"sidebar-search-btn\" title=\"搜索\">\n" +
//                 "            <i class=\"fas fa-magnifying-glass\"></i>\n" +
//                 "        </button>\n" +
//                 "    </div>\n" +
//                 "</div>        <div class=\"content-box series\"><h3>小说分类</h3><a href=\"/fictions/1.html\"><div class=\"sub checked\">全部成人小说 (18103)</div></a><a href=\"/fictions/tag-1.html\"><div class=\"sub\">人妻女友 (6495)</div></a><a href=\"/fictions/tag-101.html\"><div class=\"sub\">编辑推荐 (5991)</div></a><a href=\"/fictions/tag-102.html\"><div class=\"sub\">长篇连载 (5926)</div></a><a href=\"/fictions/tag-4.html\"><div class=\"sub\">都市生活 (5395)</div></a><a href=\"/fictions/tag-9.html\"><div class=\"sub\">家庭乱伦 (4690)</div></a><a href=\"/fictions/tag-10.html\"><div class=\"sub\">多人群交 (2720)</div></a><a href=\"/fictions/tag-13.html\"><div class=\"sub\">强暴性虐 (2545)</div></a><a href=\"/fictions/tag-8.html\"><div class=\"sub\">古典玄幻 (2192)</div></a><a href=\"/fictions/tag-2.html\"><div class=\"sub\">学生校园 (1805)</div></a><a href=\"/fictions/tag-16.html\"><div class=\"sub\">绿帽主题 (1794)</div></a><a href=\"/fictions/tag-11.html\"><div class=\"sub\">公司职场 (1404)</div></a><a href=\"/fictions/tag-7.html\"><div class=\"sub\">经验故事 (1204)</div></a><a href=\"/fictions/tag-12.html\"><div class=\"sub\">露出暴露 (993)</div></a><a href=\"/fictions/tag-999.html\"><div class=\"sub\">有声小说 (860)</div></a><a href=\"/fictions/tag-14.html\"><div class=\"sub\">西方主题 (550)</div></a><a href=\"/fictions/tag-5.html\"><div class=\"sub\">动漫游戏 (310)</div></a><a href=\"/fictions/tag-3.html\"><div class=\"sub\">伴侣交换 (281)</div></a><a href=\"/fictions/tag-15.html\"><div class=\"sub\">同性主题 (280)</div></a><a href=\"/fictions/tag-6.html\"><div class=\"sub\">名人明星 (160)</div></a><a href=\"/fictions/tag-103.html\"><div class=\"sub\">经典回忆 (109)</div></a><a href=\"/fictions/tag-99.html\"><div class=\"sub\">耽美小说 (21)</div></a><a href=\"/fictions/tag-998.html\"><div class=\"sub\">漫画小说 (4)</div></a><a href=\"/fictions/tag-1000.html\"><div class=\"sub\">色友发表 (38)</div></a></div>                <div class=\"content-box\"><div class=\"static-container-8\"><a href=\"https://xchina.app\" target=\"_blank\" clickmode=\"cpt\" clickid=\"157\" rel=\"nofollow noopener\"><div class=\"a-media zone-8\" style=\"background-image: url(https://upload.xchina.io/media/65f354c243fb6.webp);\"></div></a><a href=\"https://www.vps000.org/?code=E21C20\" target=\"_blank\" clickmode=\"cpt\" clickid=\"2\" rel=\"nofollow noopener\"><div class=\"a-media zone-8\" style=\"background-image: url(https://upload.xchina.io/media/65f35522cb457.webp);\"></div></a></div></div>    </div>\n" +
//                 "    <div class=\"right-5\">\n" +
//                 "        <div class=\"content-box\"><div class=\"static-container-4\"><a href=\"https://www.d8881.win/index.html\" target=\"_blank\" clickmode=\"cpt\" clickid=\"472\" rel=\"nofollow noopener\"><div class=\"a-media zone-4\" style=\"background-image: url(https://upload.xchina.io/media/69006d33f2f5d.webp);\"></div></a><a href=\"https://playbw88kt.com/caejwc\" target=\"_blank\" clickmode=\"cpt\" clickid=\"465\" rel=\"nofollow noopener\"><div class=\"a-media zone-4\" style=\"background-image: url(https://upload.xchina.io/media/68de37f628bf1.webp);\"></div></a><a href=\"https://playbw88kt.com/dvecwc\" target=\"_blank\" clickmode=\"cpt\" clickid=\"468\" rel=\"nofollow noopener\"><div class=\"a-media zone-4\" style=\"background-image: url(https://upload.xchina.io/media/68e6331f57b13.webp);\"></div></a><a href=\"https://hlw934.life/?a=ygzi87\" target=\"_blank\" clickmode=\"cpt\" clickid=\"462\" rel=\"nofollow noopener\"><div class=\"a-media zone-4\" style=\"background-image: url(https://upload.xchina.io/media/68dcf8ae91a9b.webp);\"></div></a><a href=\"https://tf4.juechentf.net/\" target=\"_blank\" clickmode=\"cpt\" clickid=\"457\" rel=\"nofollow noopener\"><div class=\"a-media zone-4\" style=\"background-image: url(https://upload.xchina.io/media/68db5e04ad48c.webp);\"></div></a><a href=\"https://playbw88kt.com/tehjwc\" target=\"_blank\" clickmode=\"cpt\" clickid=\"463\" rel=\"nofollow noopener\"><div class=\"a-media zone-4\" style=\"background-image: url(https://upload.xchina.io/media/68dd214f2ae5f.webp);\"></div></a><div class=\"a-media ex-728-90\"><script data-cfasync=\"false\" async type=\"text/javascript\" src=\"//ji.queachycorer.com/tpxnLfv9WzuQfBZ2/127694\"></script></div></div></div>        <div class=\"content-box fiction-controls\"><div class=\"font-size\"><div class=\"label\">字号：</div><div class=\"fiction-control-btn smaller\">A-</div><div class=\"fiction-control-btn larger\">A </div></div><div class=\"chapter-go\"><a href=\"/fiction/id-5fb6466e43a25.html\"><div class=\"fiction-control-btn prev\"><i class=\"fas fa-chevron-left\"></i>导览</div></a><a href=\"/fiction/id-dGhpc19pc19hX2ZpeGVkME1YUjJHSUZOUFUwcFpZbzRvTlVzZFE9PQ==.html\"><div class=\"fiction-control-btn next\">下一章<i class=\"fas fa-chevron-right\"></i></div></a></div></div>        <a id=\"top\"></a>\n" +
//                 "        <div class=\"content-box fiction-content\">\n" +
//                 "            <div class=\"title\">\n" +
//                 "                老婆雪儿的换妻经验            </div>\n" +
//                 "                            <div class=\"tags\"><a href=\"/fictions/tag-1.html\"><div class=\"tag\">人妻女友</div></a><a href=\"/fictions/tag-3.html\"><div class=\"tag\">伴侣交换</div></a><a href=\"/fictions/tag-10.html\"><div class=\"tag\">多人群交</div></a><a href=\"/fictions/tag-12.html\"><div class=\"tag\">露出暴露</div></a><a href=\"/fictions/tag-16.html\"><div class=\"tag\">绿帽主题</div></a><a href=\"/fictions/tag-101.html\"><div class=\"tag\">编辑推荐</div></a><a href=\"/fictions/tag-102.html\"><div class=\"tag\">长篇连载</div></a></div>\n" +
//                 "                                        <div class=\"sub-title\">\n" +
//                 "                                            <div>\n" +
//                 "                            作者：<a href=\"/fictions/keyword-蓓蓓.html\">蓓蓓</a> </div>                        </div>\n" +
//                 "                                                                            </div>\n" +
//                 "                        <div class=\"chapter-title\">\n" +
//                 "                第一章 一切的开始            </div>\n" +
//                 "                                    <div class=\"fiction-body\">\n" +
//                 "                <p>我与老婆今天都25岁，是大学认识的，现在都供职在外企单位，生活质量很不错，但压力也蛮大。当时刚见到雪儿的时候我刚和初恋分手，在心灵最空虚的时候，这个乖巧可爱的女孩就蹦进我的生活。</p><p>老婆属于那种娇小的小美女，羞涩迷人，一张洋娃娃般美丽、精致的小脸，天生一副楚楚可怜的摸样，但她却有着傲人的身材，1米60的身高才40多kg，丰满而盈润的两个乳房和翘翘的小屁股，让无数男人垂涎三尺，一双美腿和精致的小手小脚更是让人心醉。</p><p>老婆从大学到工作，没少被骚扰过，在公车上经常被揩油，去ktv唱歌也会被大学的死党们一起占点便宜，最过分的一次毕业后和几个同事去郊区旅行，晚上老婆被灌醉后竟然玩起了打牌输了脱衣服的游戏，可怜老婆牌技太差，输的连内裤都被硬扯掉了，还让人亲了小屁股和小脚才肯放回自己的房间。那天之后老婆后悔了很长时间，而我每次想起当时的情景，就会立刻硬起来，兴奋异常。</p><p>后来上网看到许多评论才了解到长时间的平淡性生活总会疲倦，需要注入一点新鲜元素才能更加激情。其实老婆也有这样的想法，每次当我看成人图片或者电影时，她总也好奇地凑过来，小脸鼓鼓红红的搭在我肩膀上。后来还让我帮她申请成人论坛的帐号，趁我不在家的时候自己经常偷偷跑上去浏览。慢慢我了解到一些夫妻交换方面的事，看了很多经历者的评论，想象着自己娇小可爱的老婆被别人侵占揉捏的时候，就兴奋到了极点。</p><p>有天晚上在我们ooxx的时候，我向她说了交换的想法，没想到她极力反对，说这些只是网上捏造和想象，绝对不可能在现实生活中去尝试。我无奈草草射了，觉得完全提不起情绪了，老婆还是很关心的趴在我身上安慰我说：“大老公，也许将来有天可以按你的愿望实现呢。”慢慢老婆坐起来，用手拨开晶莹滴两片小肉片，把小密洞对着我的嘴。</p><p>尽管已经有3年的性生活，但可能一是因为我们做的次数比较少，二是因为我的能力很一般，勃起长度才12厘米长2点5厘米粗，抽插5分钟就要射的原因，老婆的小逼还是和第一次见一样鲜嫩，粉红色的小肉片在橙色的灯光下几乎透明，毛毛覆盖的面积很少，却很浓密，老婆的小洞洞和阴蒂更是异常敏感，每次干前只要稍微安抚一下，小洞洞里就充满了淫汁，我总喜欢让老婆分腿跪在床上，看着她的淫汁顺着两个小肉片滴下来……</p><p>我知道这是老婆又发骚了，这是我和老婆形成的习惯，每次我射后都喜欢帮她口交，她说每次当我帮她口交的时候能让她感到一种舒服的快感，尤其是舔她小豆豆的时候，老婆喜欢叫自己的阴蒂小豆豆，老婆很快就乱颤着喊饶命了，但她却从来不肯帮我口交，也不让我直接内射，想到这儿，我一边舔着老婆鲜嫩的鲍鱼，一边又开始计划如何让老婆能接受换妻这件事。</p><p>后来的几天我没再提出这件事，但每天和老婆ooxx的时候，都刻意地不给她口交，果然没过两天老婆就受不了了，小洞洞里的水水一天比一天流得多了起来。</p><p>一天回家，看到老婆只穿着一件围裙过来开门，小脸气鼓鼓地撅着，故意把小乳头露在围裙边缘，若隐若现地勾引人的视线。</p><p>我一口咬住老婆的小乳头，老婆连忙小声娇滴到：“老公别这样，门还没关呢，不要让别人看到啊……啊……不要咬……”（看精彩成人小说上《成人小说网》：https://crxs.me）</p>\n" +
//                 "<p>我用舌头刷着老婆的两个小乳头说：“想让老公吃的话，就让门开着。”</p><p>老婆无奈只能开着门让我在门口吃她的小乳头，其实我们都明白，这层只有我们一家住户，所以即使开着门也完全不用担心会被别人发现。但我还是幻想着老婆被别人偷窥的情形，不觉把手伸到了老婆没有穿小内裤小缝缝上。</p><p>“哇塞！老婆，今天怎么特别湿啊，好象都滴下来了啊。”</p><p>老婆连忙夹进了腿把我拉回了屋里，赖在怀里撒娇说：“都是老公不好，也不让人家爽爽，都好几天了，一想想就流好多水水。”</p><p>我的小弟弟早已经箭在弦上，但为了更长远的计划，必须忍……</p><p>“老婆，我还有点公事要处理，这样，你先去上会网，我忙完了一会就来陪你。”</p><p>老婆可爱的小脸都快哭了出来，夹紧了自己的腿坐到了电脑旁，哀怨的眼神看着我。</p><p>我生怕再被老婆可人的模样勾引住，慌忙溜进书房。老婆坐回电脑前，鼠标一晃，好啊，她自己在家居然在看成人论坛，怪不得刚才想成那样呢……我偷偷地望过去，发现老婆在看一个可爱小女孩子的性爱写真。还真别说，照片中的那个女孩还真有点像我可爱的老婆。</p><p>待了一会，老婆慢慢的把手伸进了两腿之间，轻轻滑动了起来，我装作看图纸，完全不理会她，老婆的动作慢慢大了一点，为了不发出声音闭紧了小嘴，挺挺的乳房上面，两个粉红色的小乳头翘了起来，从我对她平时的观察，知道她马上要“爽爽”了，果然，老婆轻轻地哼了一声整个身体趴到了电脑桌上……老婆以前从未在我面前手淫过，我看的也欲火高烧，自己打飞机射了出来。</p><p>第二天我到成人用品商店买了一根按摩棒，晚上回家爱爱的时候，又看见老婆只穿着小围裙坐在电脑旁看成人论坛。这次可不能放过骚骚的老婆了，抱起她娇小的身子一边吃着她高高翘起的小乳粒，一边把她按到床上。老婆羞涩地闭上眼睛，一只手拨开自己的阴户一只手拿着我的鸡巴在阴道口上摩擦。我用力一顶将阴茎一下全部插入老婆细嫩的小肉洞，老婆阴道流出大量的蜜汁都几乎被挤出来。</p><p>“老婆你是不是很骚啊？洞洞里这么多水，插一下都要流出来好多。”</p><p>“大坏老公……啊……快点插我……我是骚骚老婆……啊……老公……”</p><p>这么长时间没给过老婆，她今天果然特别敏感，每次插到深处，都会颤动一下。老婆洞洞里的小肉芽被淫汁泡的晶莹可人，把我的鸡巴弄的特别舒服，很快就让我有了想射的冲动。我赶忙把摩棒插上电，一边减弱了抽送速度，一边用按摩头对上老婆的小豆豆，老婆从没用过这样的东西，先是吃惊的睁大眼睛，马上就被电击了一样，发起嗲来：“老公你拿得是什么呀？啊……小豆豆好舒服……啊……不要停……老公插我……老公插我……”</p><p>老婆屁股扭动着好让我的鸡巴能更强烈的抽插，我感到她的小肉洞越来越紧里面的淫汁越来越多，每下抽送都能带出好多淫汁流到老婆性感的屁股上。</p>（<a href=\"https://xchina.app\" target=\"_blank\" style=\"color: #00c;\">成人APP精选（https://xchina.app），每款都经过站长人工审核</a>）<p>“啊……老公……再插快点……我要大鸡鸡……啊……”老婆洞洞里小肉芽强烈的按压我的鸡巴，这是我以前从未感受过的，很快便缴了枪。老婆还意由未尽地用小肉洞来回套弄着我已经软掉的鸡巴。</p><p>“老公……刚才你用的震动的是什么呀……放在小豆豆上好舒服啊，比老公的舌头舔还舒服……”</p><p>“那个是按摩棒，只要插上电就能震动，骚老婆刚才是不是很爽啊？”</p><p>“就是老公的时间太短了……哼，我看别人写的都能插半个多小时呢……”老婆赖在我的怀里撒娇地说。</p><p>“不可能的，哪能插这么长时间，肯定是在骗老婆，你说是谁能插半小时？让他来插插我的漂亮老婆，看能不能坚持住？”</p><p>“老公你好坏……我才不要别人插我呢，只要老公一个人的大鸡鸡。”</p><p>尽管老婆这么说，可我心想这第一步已经算是完成了。果然以后老婆自己在家的时候，经常偷偷地看着我给她下载的av片或者图片用按摩棒自慰。而在我们爱爱的时候，我也会让他幻想着按摩棒是另一个人的大鸡鸡要和老公一起欺负老婆。</p><p>老婆慢慢的习惯了按摩棒，每次做爱都必须要我和按摩棒一起抽插她的小嫩洞。因为按摩棒的震动和老婆的小洞洞里淫水、肉芽的刺激每次我射得都比以前快点，老婆每次在我射完后都会有点不开心，总是央求我下次时间再长点。</p><p>后来，我又给老婆申请了一个视频聊天帐号，老婆一开始害羞，只肯看看别的女孩怎么在聊天群里展现自己，看着其他狼友的大鸡鸡老婆的小洞洞也会变的很湿，一边看着其他大鸡鸡一边让我抽插她的小淫洞。</p><p>慢慢她偶尔开一下自己的视频，开始拘束得很，穿得厚厚的，一但有人关注她，就立刻下线跑掉，我鼓励老婆，告诉她她的身材是多么完美，而且又只用摄像头对着身体，完全没必要担心，这她才能放开一点，在聊天室的群狼里立刻成了焦点，主持人每次看她上线，都号召所有人一起看她的表演。</p><p>老婆很被动，但很乖，按着主持人的诱导，每次都会脱的一丝不挂，还要露出小肉洞给他们看。而每次视频之后老婆和我都是特别兴奋，我让她想象着我是不同的狼友正在干她，老婆一边点头，一边喊出和她视频聊天的人的那些名字，而老婆喊的这些人在视频上看起来鸡鸡都是特别大特别粗的那些。</p><p>这样持续了1个多月，当我偶尔提出想让老婆在现实里尝试一下和别人做爱时，老婆还是不答应，但没有一口回绝，只是说，网络上因为不认识，所以没关系，生活中都可能碰到，她接受不了。几次下来我也没了办法，老婆这么坚持，我想没什么希望了。</p>                <div class=\"fiction-chapter-navigator\"><a href=\"/fiction/id-5fb6466e43a25.html\"><div class=\"fiction-control-btn prev\"><i class=\"fas fa-chevron-left\"></i>导览</div></a><a href=\"/fiction/id-dGhpc19pc19hX2ZpeGVkME1YUjJHSUZOUFUwcFpZbzRvTlVzZFE9PQ==.html\"><div class=\"fiction-control-btn next\">下一章<i class=\"fas fa-chevron-right\"></i></div></a></div>            </div>\n" +
//                 "        </div>\n" +
//                 "                <a id=\"comment\"></a>\n" +
//                 "        \n" +
//                 "\n" +
//                 "<script>\n" +
//                 "    var commentOptions = {\"dataMode\":\"object\",\"dataObject\":{\"mode\":\"fiction\",\"id\":\"5fb6466e43a25\"},\"words\":{\"success\":\"操作成功\",\"reply\":\"回复\",\"view\":\"查看\",\"submitReply\":\"添加公开回复\",\"cancel\":\"取消\",\"hideReplies\":\"隐藏回复\",\"n_replies\":\"条回复\",\"n_floor\":\"楼\",\"no_record\":\"还没有人发表过评论\",\"no_record_my\":\"您还没有发表过评论\",\"translate\":\"翻译它\",\"translation\":\"翻译：\",\"translating\":\"翻译中\",\"translate_failed\":\"翻译失败\",\"comment_success\":\"评论发表成功\"},\"config\":{\"maxChar\":300,\"maxReplyLength\":300,\"selectors\":{\"dataContainer\":\".data\",\"pagerContainer\":\".pager-js\"},\"scrollAnchor\":\"#comment_start\",\"scrollOffset\":100,\"scrollDuration\":500}};\n" +
//                 "    var userInfo = {\"Nickname\":\"新加坡色友\",\"AvatarHtml\":\"<div class=\\\"avatar char s40\\\">新<\\/div>\"};\n" +
//                 "    var quickRepliesData = [\"这么好的帖，不推对不起自己啊\",\"由衷感謝大大精彩的分享 !\",\"楼主一生平安！（请狼友保持队形）…\",\"对楼主的敬意犹如滔滔流水连绵不绝，又如黄河泛滥一发而不可收\",\"真是生我者父母，知我者楼主呀！\",\"故事很精彩，看in了\",\"真是让人印象深刻的文章啊！\",\"小黄书里看黄书，零丁洋里叹零丁\",\"夕阳西下，断肠人在天涯\",\"这种真情实意的小黄文是没有一定的亲身体验写不出来的\",\"字里行间无不流露出作者身上无法隐藏的那股骚劲\",\"读书吧，它会使你的生活变得舒畅愉快  --高尔基\",\"救救孩子，让孩子本着自己的兴趣多读书吧  --不是鲁迅说的\",\"书是伟大淫才留给全人类的遗产 --也不是鲁迅说的\",\"读书使人头脑聪明  --伏尔泰\",\"这是一篇积极的催人泪下的小黄书，请带着健康的心理观看\",\"故事太诱惑人了，要是发生在我身上就好了\",\"写的真好，看的我也想去写小说了\",\"这不就是写的我老婆的故事吗？\",\"在我所有看过的小说里，该文属于最棒的1\\/n（n>=1000000）\",\"小说写的非常好，故事情节诱人，感情细腻而真实，作者一定是大师级的人物\",\"喂喂喂，有人吗？好像还没完结呢，抓紧写完呀，加油！\",\"刚看了个开头就把我吸引住了，收藏了慢慢看~\",\"文笔不错，就是剧情略感单薄\",\"写的很好，很真实\",\"贵在真实，值得一看\",\"给大大手动点赞\uD83D\uDC4D\",\"感谢大大分享！1024！\"];\n" +
//                 "</script>\n" +
//                 "\n" +
//                 "<script>\n" +
//                 "    var minChar = 4;\n" +
//                 "    var maxChar = 300;\n" +
//                 "\n" +
//                 "    $(document).ready(function() {\n" +
//                 "        var currentStarRating = 0;\n" +
//                 "\n" +
//                 "        function initStarRating() {\n" +
//                 "            $('.star-rating').each(function() {\n" +
//                 "                var $rating = $(this);\n" +
//                 "                var $labels = $rating.find('label');\n" +
//                 "\n" +
//                 "                $labels.on('mouseenter', function() {\n" +
//                 "                    var starId = $(this).attr('for');\n" +
//                 "                    var value = parseInt(starId.replace('star', ''));\n" +
//                 "                    showStars($rating, value, true);\n" +
//                 "                });\n" +
//                 "\n" +
//                 "                $rating.on('mouseleave', function() {\n" +
//                 "                    showStars($rating, currentStarRating, false);\n" +
//                 "                });\n" +
//                 "\n" +
//                 "                $labels.on('click', function() {\n" +
//                 "                    var starId = $(this).attr('for');\n" +
//                 "                    var value = parseInt(starId.replace('star', ''));\n" +
//                 "\n" +
//                 "                    if (currentStarRating === value) {\n" +
//                 "                        currentStarRating = 0;\n" +
//                 "                        $rating.find('input[type=\"radio\"]').prop('checked', false);\n" +
//                 "                    } else {\n" +
//                 "                        currentStarRating = value;\n" +
//                 "                        $('#'   starId).prop('checked', true);\n" +
//                 "                    }\n" +
//                 "\n" +
//                 "                    showStars($rating, currentStarRating, false);\n" +
//                 "                });\n" +
//                 "            });\n" +
//                 "        }\n" +
//                 "\n" +
//                 "        function showStars($rating, count, isHover) {\n" +
//                 "            var $labels = $rating.find('label');\n" +
//                 "\n" +
//                 "            $labels.removeClass('active hover-active');\n" +
//                 "\n" +
//                 "            for (var i = 1; i <= count; i  ) {\n" +
//                 "                var $label = $rating.find('label[for=\"star'   i   '\"]');\n" +
//                 "                if (isHover) {\n" +
//                 "                    $label.addClass('hover-active');\n" +
//                 "                } else {\n" +
//                 "                    $label.addClass('active');\n" +
//                 "                }\n" +
//                 "            }\n" +
//                 "        }\n" +
//                 "\n" +
//                 "        function getCurrentRating() {\n" +
//                 "            return currentStarRating;\n" +
//                 "        }\n" +
//                 "\n" +
//                 "        function setRating(rating) {\n" +
//                 "            currentStarRating = rating;\n" +
//                 "            var $rating = $('.star-rating');\n" +
//                 "            if (rating > 0) {\n" +
//                 "                $('#star'   rating).prop('checked', true);\n" +
//                 "            } else {\n" +
//                 "                $rating.find('input[type=\"radio\"]').prop('checked', false);\n" +
//                 "            }\n" +
//                 "            showStars($rating, currentStarRating, false);\n" +
//                 "        }\n" +
//                 "\n" +
//                 "        initStarRating();\n" +
//                 "\n" +
//                 "        $(\"a[name='submit-comment']\").click(function() {\n" +
//                 "            let $btn = $(this);\n" +
//                 "            if (!$btn.hasClass(\"disabled\")) {\n" +
//                 "                $btn.addClass(\"disabled\");\n" +
//                 "\n" +
//                 "                var scoreValue = $(\"input[type='radio'][name='score']:checked\").val();\n" +
//                 "\n" +
//                 "                my.ajax({\n" +
//                 "                    action: \"submitComment\",\n" +
//                 "                    objMode: commentOptions.dataObject.mode,\n" +
//                 "                    objId: commentOptions.dataObject.id,\n" +
//                 "                    content: $(\"textarea[name='comment']\").val().trim(),\n" +
//                 "                    country: $(\".quick-reply select[name='country']\").val(),\n" +
//                 "                    score: scoreValue\n" +
//                 "                }, function(result) {\n" +
//                 "                    $btn.removeClass(\"disabled\");\n" +
//                 "                    switch (result.code) {\n" +
//                 "                        case 0:\n" +
//                 "                            my.success(commentOptions.words.comment_success);\n" +
//                 "                            $(\"textarea[name='comment']\").val(\"\");\n" +
//                 "                            currentStarRating = 0;\n" +
//                 "                            $('.star-rating input[type=\"radio\"]').prop('checked', false);\n" +
//                 "                            showStars($('.star-rating'), 0, false);\n" +
//                 "                            commentManager.commentPage = 1;\n" +
//                 "                            commentManager.getComments();\n" +
//                 "                            break;\n" +
//                 "                        default:\n" +
//                 "                            my.error(result.message);\n" +
//                 "                            break;\n" +
//                 "                    }\n" +
//                 "                });\n" +
//                 "            }\n" +
//                 "        });\n" +
//                 "\n" +
//                 "        $(\".quick-reply-btn\").click(function() {\n" +
//                 "            showQuickReplyModal();\n" +
//                 "        });\n" +
//                 "\n" +
//                 "        $(\"textarea[name='comment']\").keyup(function() {\n" +
//                 "            var charCount = $(this).val().length;\n" +
//                 "            $(\".charCount\").text(charCount   \" / \"   maxChar);\n" +
//                 "        }).trigger(\"keyup\");\n" +
//                 "\n" +
//                 "        window.getCurrentRating = getCurrentRating;\n" +
//                 "        window.setRating = setRating;\n" +
//                 "    });\n" +
//                 "\n" +
//                 "    function showQuickReplyModal() {\n" +
//                 "        if (!quickRepliesData || Object.keys(quickRepliesData).length === 0) {\n" +
//                 "            return;\n" +
//                 "        }\n" +
//                 "\n" +
//                 "        var quickReplyListHtml = '<div class=\"quick-reply-list\">';\n" +
//                 "        for (var key in quickRepliesData) {\n" +
//                 "            var replyText = quickRepliesData[key];\n" +
//                 "            quickReplyListHtml  = '<div class=\"quick-reply-item\" data-reply=\"'   replyText.replace(/\"/g, '&quot;')   '\">';\n" +
//                 "            quickReplyListHtml  = '<div class=\"reply-text\">'   replyText   '</div>';\n" +
//                 "            quickReplyListHtml  = '</div>';\n" +
//                 "        }\n" +
//                 "        quickReplyListHtml  = '</div>';\n" +
//                 "\n" +
//                 "        quickReplyListHtml  = '<style>';\n" +
//                 "        quickReplyListHtml  = '.quick-reply-list { max-height: 400px; overflow-y: auto; }';\n" +
//                 "        quickReplyListHtml  = '.quick-reply-item { padding: 10px; border-bottom: 1px solid #eee; cursor: pointer; transition: background-color 0.2s; }';\n" +
//                 "        quickReplyListHtml  = '.quick-reply-item:hover { background-color: #f5f5f5; }';\n" +
//                 "        quickReplyListHtml  = '.quick-reply-item:last-child { border-bottom: none; }';\n" +
//                 "        quickReplyListHtml  = '.reply-text { line-height: 1.4; }';\n" +
//                 "        quickReplyListHtml  = '</style>';\n" +
//                 "\n" +
//                 "        var modal = new Modal({\n" +
//                 "            threeSection: true,\n" +
//                 "            headerText: \"快捷回复\",\n" +
//                 "            showDefaultCloseButton: true,\n" +
//                 "            showHeaderCloseButton: true,\n" +
//                 "            backdropClose: true,\n" +
//                 "            escClose: true\n" +
//                 "        });\n" +
//                 "\n" +
//                 "        modal.setContent(quickReplyListHtml).showModal();\n" +
//                 "\n" +
//                 "        setTimeout(function() {\n" +
//                 "            $('.quick-reply-item').click(function() {\n" +
//                 "                var replyText = $(this).data('reply');\n" +
//                 "                $(\"textarea[name='comment']\").val(replyText).trigger('keyup');\n" +
//                 "                modal.closeModal();\n" +
//                 "            });\n" +
//                 "        }, 100);\n" +
//                 "    }\n" +
//                 "</script>\n" +
//                 "\n" +
//                 "<a id=\"anchor-comment\"></a>\n" +
//                 "<div class=\"content-box comments\">\n" +
//                 "    <div class=\"header\">\n" +
//                 "        <div class=\"title-lr\">\n" +
//                 "            <div class=\"left\">\n" +
//                 "                色友点评                (1)            </div>\n" +
//                 "        </div>\n" +
//                 "    </div>\n" +
//                 "    <div class=\"layout-lr\">\n" +
//                 "        <div class=\"left-fixed-50\">\n" +
//                 "            <div class=\"user-avatar\">\n" +
//                 "                <div class=\"avatar char s40\">新</div>            </div>\n" +
//                 "        </div>\n" +
//                 "        <div>\n" +
//                 "            <div class=\"submit-comment\">\n" +
//                 "                <div class=\"submit\">\n" +
//                 "                                            <div class=\"quick-reply\">\n" +
//                 "                            <button type='button' class='btn comment-dot smaller quick-reply-btn'>快捷回复</button>                                                    </div>\n" +
//                 "                                        <div class=\"textarea-container\">\n" +
//                 "                        <textarea name=\"comment\" placeholder=\"无需注册就能点评，试试吧\"></textarea>\n" +
//                 "                    </div>\n" +
//                 "                                            <div class=\"rating\">\n" +
//                 "                            <div class=\"submit-score star-rating\">\n" +
//                 "                                <input type=\"radio\" name=\"score\" id=\"star1\" value=\"1\" />\n" +
//                 "                                <label for=\"star1\"></label>\n" +
//                 "                                <input type=\"radio\" name=\"score\" id=\"star2\" value=\"2\" />\n" +
//                 "                                <label for=\"star2\"></label>\n" +
//                 "                                <input type=\"radio\" name=\"score\" id=\"star3\" value=\"3\" />\n" +
//                 "                                <label for=\"star3\"></label>\n" +
//                 "                                <input type=\"radio\" name=\"score\" id=\"star4\" value=\"4\" />\n" +
//                 "                                <label for=\"star4\"></label>\n" +
//                 "                                <input type=\"radio\" name=\"score\" id=\"star5\" value=\"5\" />\n" +
//                 "                                <label for=\"star5\"></label>\n" +
//                 "                            </div>\n" +
//                 "                        </div>\n" +
//                 "                                        <div class=\"button-line\">\n" +
//                 "                        <span class=\"charCount\"></span>\n" +
//                 "                        <a name=\"submit-comment\" class=\"btn yes button-submit-comment\">发表评论</a>\n" +
//                 "                    </div>\n" +
//                 "                                            <div class=\"rules\">\n" +
//                 "                            <ul>\n" +
//                 "                                                                    <li>\n" +
//                 "                                        任何人都可以发表评论，注册用户会显示昵称，未注册用户会显示所在国家；                                    </li>\n" +
//                 "                                                                                                    <li>\n" +
//                 "                                        本站崇尚言论自由，我们不设审查，但对以下情况零容忍，违反者会受到封号乃至封禁 IP 的处罚：                                        <ul>\n" +
//                 "                                            <li>\n" +
//                 "                                                发广告（任何出现他站网址或引导进入他站的都会被视为广告）；                                            </li>\n" +
//                 "                                            <li>\n" +
//                 "                                                暴力、仇恨或歧视言论；                                            </li>\n" +
//                 "                                                                                        <li>\n" +
//                 "                                                无意义的灌水；                                            </li>\n" +
//                 "                                            <li>\n" +
//                 "                                                同一主题请以回复方式发表在一篇评论中，禁止发表多个评论影响其他色友阅读；                                            </li>\n" +
//                 "                                                                                            <li>\n" +
//                 "                                                    <a href=\"/blog/id-677ba804c2777.html\">收起戾气，文明讨论；</a>\n" +
//                 "                                                </li>\n" +
//                 "                                                                                    </ul>\n" +
//                 "                                    </li>\n" +
//                 "                                                                                            </ul>\n" +
//                 "                        </div>\n" +
//                 "                                    </div>\n" +
//                 "            </div>\n" +
//                 "        </div>\n" +
//                 "    </div>\n" +
//                 "    <div>\n" +
//                 "        <a id=\"comment_start\"></a>\n" +
//                 "        <div class=\"pager-js\"></div>\n" +
//                 "        <div class=\"data\"></div>\n" +
//                 "        <div class=\"pager-js\"></div>\n" +
//                 "    </div>\n" +
//                 "</div>        <div class=\"content-box\"><div class=\"static-container-5\"><a href=\"https://xchina.app\" target=\"_blank\" clickmode=\"cpt\" clickid=\"151\" rel=\"nofollow noopener\"><div class=\"a-media zone-5\" style=\"background-image: url(https://upload.xchina.io/media/65fe05db43ce8.webp);\"></div></a><a href=\"http://154.17.22.56/lvd?channel=xhs-bottom2\" target=\"_blank\" clickmode=\"cpt\" clickid=\"442\" rel=\"nofollow noopener\"><div class=\"a-media zone-5\" style=\"background-image: url(https://upload.xchina.io/media/6890054f5fe9b.webp);\"></div></a></div></div>        <div class=\"banner-sexgps\"><div><div><a href=\"https://sexgps.net\" target=\"_blank\" title=\"色情导航收集了各类优质成人色情资源，如：成人网站、成人视频、成人APP、成人漫画、成人小说、成人下载等，让你一次撸个够…\">色情导航：</a></div><div><a href=\"https://sexgps.net/site.html?id=6865053a4d4ad\" target=\"_blank\" title=\"蓝猫vpn - 2025 看片神器 (送谷歌和飞机账号)\">蓝猫vpn</a></div><div><a href=\"https://sexgps.net/site.html?id=684d441f3d5c4\" target=\"_blank\" title=\"小小妹中学门 - 福建兄妹，紫色面具，事件门，大开眼界\">小小妹中学门</a></div><div><a href=\"https://sexgps.net/site.html?id=669c9c7067019\" target=\"_blank\" title=\"中国嫖娼地图 - 中国最全最便宜的招嫖信息\">中国嫖娼地图</a></div><div><a href=\"https://sexgps.net/site.html?id=675fd51669f69\" target=\"_blank\" title=\"蓝莓VPN - VPN性价王，免费试用，3元会员\">蓝莓VPN</a></div><div><a href=\"https://sexgps.net/site.html?id=67fd2b24e5d76\" target=\"_blank\" title=\"吃瓜69 - 炸裂吃瓜網紅明星私密爆料\">吃瓜69</a></div><div><a href=\"https://sexgps.net/site.html?id=686d87b843b0a\" target=\"_blank\" title=\"稀缺精品 - 收集各种稀缺猎奇合集\">稀缺精品</a></div><div><a href=\"https://sexgps.net/site.html?id=687cf93768bb5\" target=\"_blank\" title=\"澳门金沙赌场 - 澳门金沙赌场注册即送18元\">澳门金沙赌场</a></div><div><a href=\"https://sexgps.net/site.html?id=68df866734e8c\" target=\"_blank\" title=\"3D性爱游戏 - 全网最全性爱游戏\">3D性爱游戏</a></div><div><a href=\"https://sexgps.net/site.html?id=68c7d2df63478\" target=\"_blank\" title=\"小萝莉户外露出 - 大尺度人前露出\">小萝莉户外露出</a></div><div><a href=\"https://sexgps.net/site.html?id=673dd9cd09637\" target=\"_blank\" title=\"吃瓜爆料网 - 成人免费爆料网，明星/高官/白领/教师\">吃瓜爆料网</a></div><div><a href=\"https://sexgps.net/site.html?id=68ed21ed72993\" target=\"_blank\" title=\"麻豆头条吃瓜 - 全网吃瓜黑料头条 | 明星网红爆料\">麻豆头条吃瓜</a></div><div><a href=\"https://sexgps.net/site.html?id=67a2bd43d4195\" target=\"_blank\" title=\"创世直播 - 每一秒都是现场，每一刻都是传奇\">创世直播</a></div><div><a href=\"https://sexgps.net/site.html?id=68fcb04304278\" target=\"_blank\" title=\"小黄鸟 - 黄推福利姬探花内容平台 | 推特视频下载\">小黄鸟</a></div><div><a href=\"https://sexgps.net/site.html?id=686b6d42bc964\" target=\"_blank\" title=\"U体育 - 亚洲第一体育平台\">U体育</a></div><div><a href=\"https://sexgps.net/site.html?id=683a0732b2659\" target=\"_blank\" title=\"AI在线性爱游戏 - 千万种性爱场景，自由交互\">AI在线性爱游戏</a></div><div><a href=\"https://sexgps.net/site.html?id=68f375ec9173b\" target=\"_blank\" title=\"百万爆料视频 - 汇集全网爆料视频\">百万爆料视频</a></div><div><a href=\"https://sexgps.net/site.html?id=6852b18b2983c\" target=\"_blank\" title=\"全球最强抖音成人版 - 一站满足全部欲望\">全球最强抖音成人版</a></div><div><a href=\"https://sexgps.net/site.html?id=67eaaa20068ae\" target=\"_blank\" title=\"AI去衣黑科技 - 秒去衣|AI去衣黑科技\">AI去衣黑科技</a></div><div><a href=\"https://sexgps.net/site.html?id=678e43a921150\" target=\"_blank\" title=\"女厕偷拍  裙底偷拍 - 酒店破解摄像头直播\">女厕偷拍  裙底偷拍</a></div><div><a href=\"https://sexgps.net/site.html?id=68fcf5932da3a\" target=\"_blank\" title=\"佳妮俱乐部 - 全网最强高端约会、商务模特、外围、福利姬\">佳妮俱乐部</a></div><div><a href=\"https://sexgps.net/site.html?id=68f8abca1eaf5\" target=\"_blank\" title=\"黑料网 - 每日更新网红明星黑料吃瓜爆料\">黑料网</a></div><div><a href=\"https://sexgps.net/site.html?id=681e3e5d43406\" target=\"_blank\" title=\"仅限新加坡_是您网 - 新加坡最好的小姐姐网站\">仅限新加坡_是您网</a></div><div><a href=\"https://sexgps.net/site.html?id=681128e06bacb\" target=\"_blank\" title=\"萝莉岛 - 萝莉岛事件揭秘、暗网资源、网红爆料、抖音网红吃瓜\">萝莉岛</a></div><div><a href=\"https://sexgps.net/site.html?id=6818f71219aba\" target=\"_blank\" title=\"AI风月 - 全球最大中文无限制AI色情\">AI风月</a></div><div><a href=\"https://sexgps.net/site.html?id=68de64a2d7b1c\" target=\"_blank\" title=\"人妻日记 - 万部免费视频  成人在线观看\">人妻日记</a></div><div><a href=\"https://sexgps.net/site.html?id=68e5704a21c1c\" target=\"_blank\" title=\"5x5x影院 - 热门黑料,免费在线观看,每天更新300部\">5x5x影院</a></div><div><a href=\"https://sexgps.net/site.html?id=673dd9cf17fdc\" target=\"_blank\" title=\"黑料百科 - 成人免费爆料网，明星/高官/白领/教师\">黑料百科</a></div><div><a href=\"https://sexgps.net/site.html?id=6597201626c89\" target=\"_blank\" title=\"秀人网 - 秀人网及旗下品牌全集，提供打包下载\">秀人网</a></div><div><a href=\"https://sexgps.net/site.html?id=654be17a39a53\" target=\"_blank\" title=\"H動漫網 - 免費的線上看成人色情卡通片\">H動漫網</a></div><div><a href=\"https://sexgps.net/site.html?id=65e30e218d775\" target=\"_blank\" title=\"疯情书库 - 辣文小黄文高h小说在线阅读\">疯情书库</a></div><div><a href=\"https://sexgps.net/site.html?id=654be00c22e2f\" target=\"_blank\" title=\"色花堂 - 老牌中文成人论坛\">色花堂</a></div><div><a href=\"https://sexgps.net/site.html?id=654bd168d8235\" target=\"_blank\" title=\"Redtube - 世界最大的色情网站之一！\">Redtube</a></div><div><a href=\"https://sexgps.net/site.html?id=654c7f060bc4f\" target=\"_blank\" title=\"套图学院 - 国模写真及私拍套图\">套图学院</a></div><div><a href=\"https://sexgps.net/site.html?id=686b815a1d4cf\" target=\"_blank\" title=\"JavSB\">JavSB</a></div><div><a href=\"https://sexgps.net/site.html?id=65ad74daa2a80\" target=\"_blank\" title=\"新美图录 - 收集整理各类美女图片\">新美图录</a></div><div><a href=\"https://sexgps.net/site.html?id=65e8bc78170b8\" target=\"_blank\" title=\"酷18 - 综合性成人论坛\">酷18</a></div><div><a href=\"https://sexgps.net/site.html?id=654bda27bae0b\" target=\"_blank\" title=\"街拍第一站 - 街头拍摄良家美女\">街拍第一站</a></div><div><a href=\"https://sexgps.net/site.html?id=654be126a02f5\" target=\"_blank\" title=\"H動漫 - H動漫/裏番/線上看\">H動漫</a></div><div><a href=\"https://sexgps.net/site.html?id=654be31f9826a\" target=\"_blank\" title=\"九妖漫画网 - 优质韩漫、日漫、每日更新\">九妖漫画网</a></div><div><a href=\"https://sexgps.net/site.html?id=65ff189fce2f4\" target=\"_blank\" title=\"好视角图片网 - 各个角度欣赏女人的美\">好视角图片网</a></div><div><a href=\"https://sexgps.net/site.html?id=65dbabb936fa1\" target=\"_blank\" title=\"Youavhub - 免費日本AV高清影片\">Youavhub</a></div><div><a href=\"https://sexgps.net/site.html?id=6594040799504\" target=\"_blank\" title=\"艾薇福利社 - 丝袜写真|美女美图\">艾薇福利社</a></div><div><a href=\"https://sexgps.net/site.html?id=6550eea5e3433\" target=\"_blank\" title=\"夜色王朝 - 综合性中文成人论坛\">夜色王朝</a></div><div><a href=\"https://sexgps.net/site.html?id=654ca52ba3aaf\" target=\"_blank\" title=\"南  South Plus - 综合性成人网站，需要注册才能浏览\">南  South Plus</a></div><div><a href=\"https://sexgps.net/site.html?id=654bde6eea9cc\" target=\"_blank\" title=\"丽图·污漫画 - 免费看韩国/日本的色情漫画和H漫画\">丽图·污漫画</a></div><div><a href=\"https://sexgps.net/site.html?id=654bcf5fed2bb\" target=\"_blank\" title=\"JAVDAY.TV - 免費高清AV在線看\">JAVDAY.TV</a></div><div><a href=\"https://sexgps.net/site.html?id=6550d88a6508c\" target=\"_blank\" title=\"Metarthunter.com - 欧美成人图片在线看\">Metarthunter.com</a></div><div><a href=\"https://sexgps.net/site.html?id=654bd93b08164\" target=\"_blank\" title=\"中国原创 - 在线中文、日本AV\">中国原创</a></div><div><a href=\"https://sexgps.net/site.html?id=65c51cd949daf\" target=\"_blank\" title=\"柠檬皮美女资讯站 - 会员制美女图片站\">柠檬皮美女资讯站</a></div><div><a href=\"https://sexgps.net/site.html?id=65bc100497fb3\" target=\"_blank\" title=\"美图鉴赏 - Coser写真图片\">美图鉴赏</a></div></div></div>    </div>\n" +
//                 "</div>\n" +
//                 "\n" +
//                 "<script>\n" +
//                 "    $(function() {\n" +
//                 "        var fontSizes = [\"0.8\",\"0.9\",\"1\",\"1.1\",\"1.2\",\"1.3\",\"1.4\",\"1.5\"];\n" +
//                 "        var $body = $(\".fiction-body\");\n" +
//                 "        var $smaller = $(\".fiction-control-btn.smaller\");\n" +
//                 "        var $larger = $(\".fiction-control-btn.larger\");\n" +
//                 "        var cookieKey = \"__fiction_font-size\";\n" +
//                 "        var curIndex = fontSizes.indexOf(\"1\");\n" +
//                 "\n" +
//                 "        function updateFont() {\n" +
//                 "            $body.css(\"font-size\", fontSizes[curIndex]   \"rem\");\n" +
//                 "            my.setCookie(cookieKey, fontSizes[curIndex]);\n" +
//                 "            $smaller.toggleClass(\"disabled\", curIndex === 0);\n" +
//                 "            $larger.toggleClass(\"disabled\", curIndex === fontSizes.length - 1);\n" +
//                 "        }\n" +
//                 "        $smaller.click(function() {\n" +
//                 "            if (curIndex > 0) {\n" +
//                 "                curIndex--;\n" +
//                 "                updateFont();\n" +
//                 "            }\n" +
//                 "        });\n" +
//                 "        $larger.click(function() {\n" +
//                 "            if (curIndex < fontSizes.length - 1) {\n" +
//                 "                curIndex  ;\n" +
//                 "                updateFont();\n" +
//                 "            }\n" +
//                 "        });\n" +
//                 "    });\n" +
//                 "</script></div>\n" +
//                 "\n" +
//                 "\n" +
//                 "\n" +
//                 "<footer class=\"mobile\"><a href=\"/\"><div class=\"menu-item\"><div><i class=\"fas fa-home\"></i></div><div>首页</div></div></a><a href=\"/search.html\"><div class=\"menu-item\"><div><i class=\"fas fa-magnifying-glass\"></i></div><div>搜索</div></div></a><a href=\"javascript: share();\"><div class=\"menu-item\"><div><i class=\"fas fa-share\"></i></div><div>分享</div></div></a><a href=\"javascript: toggleFav();\"><div class=\"menu-item fav\"><div><i class=\"far fa-heart\"></i></div><div>收藏</div></div></a><a href=\"/my.html\"><div class=\"menu-item\"><div><i class=\"far fa-user\"></i></div><div>我的</div></div></a></footer><script>\n" +
//                 "var share = function () {\n" +
//                 "    const shareModal = new Modal({\n" +
//                 "        threeSection: false,\n" +
//                 "        showDefaultCloseButton: true,\n" +
//                 "        escClose: true,\n" +
//                 "        backdropClose: true\n" +
//                 "    });\n" +
//                 "\n" +
//                 "    const shareContent = `\n" +
//                 "        <div class=\"modal-share\">\n" +
//                 "            <div>\n" +
//                 "                <img class=\"qrcode\" src=\"/images/empty.png\" />\n" +
//                 "            </div>\n" +
//                 "            <div>\n" +
//                 "                当前网址二维码\n" +
//                 "            </div>\n" +
//                 "            <div>\n" +
//                 "                <a name=\"BtnCopy\" class=\"btn btn-clone\" copyvalue=\"https://crxs.me/fiction.php\" copycaption=\"已复制\">\n" +
//                 "                    <i class=\"fas fa-clone\"></i> 复制当前网址\n" +
//                 "                </a>\n" +
//                 "            </div>\n" +
//                 "        </div>\n" +
//                 "    `;\n" +
//                 "\n" +
//                 "    shareModal.setContent(shareContent).showModal();\n" +
//                 "    my.initCopy();\n" +
//                 "    \n" +
//                 "    const qrcodeImg = shareModal.modalElement.querySelector('.qrcode');\n" +
//                 "    if (qrcodeImg && !qrcodeImg.getAttribute('loaded')) {\n" +
//                 "        qrcodeImg.setAttribute('loaded', 'true');\n" +
//                 "        qrcodeImg.src = \"/qrcode.php?url=https://crxs.me/fiction.php\";\n" +
//                 "    }\n" +
//                 "};\n" +
//                 "</script><footer class=\"pc\"><div><div>Copyright © 2025 成人小说网</div></div><div><div class=\"links\"><div>友情链接：</div><a clickmode=\"link\" clickid=\"1231\" href=\"https://xchina.app\" target=\"_blank\" rel=\"nofollow\">成人APP精选</a> | <a clickmode=\"link\" clickid=\"1319\" href=\"https://seyeah.com\" target=\"_blank\">色也·搜你想看</a></div><div class=\"exchange\"> | <a href=\"https://xchina.fit/ad.html\" target=\"_blank\">广告服务</a></div></div></div></footer><script>let visitUrl = 'https://v2.6888.site/v2.html?s=x8tB2fAorHSiJxwBf0F4L1RWbWo2RWhLSmF2dGxZOCt5UVBtWWZOVm1URng4andRVWx6U3YyVmxpK083ek9sVmFUOFNzcThlblI1RHcrTlJkOHNudHdUV0E2bzdpb2tUaXptQ09pKzN3aC9NRGtBTk5MdlhzaTZkNzNvK0xWUWpxbUhNbUtJemlRajVOUzJPemFqaHp6NHFJRlhYcmthbTEzU3F3SDhtVVM0cTdNcmorMTV4Rm1XUnVhc09NRVhjRVRsWUhLb0JLSW01V0NzeW5iTVFoREIyN2NsdGpPQVlCY2FoZ25DTXNtamZXaFVWMG1mNVZEYjQ4OFN6VjZ5aW16cmFlL0k1YmtqcENLTVF6am9Td2syVXBkbnV1SEdyTnJ0L2lJa3Y1czZQdm1oNFhnZ2hPVzNvMzhaQ0lYZDFQeFQ3ekRNN1RnUmZZMklO';let script = document.createElement('script');script.src = visitUrl   (visitUrl.includes('?') ? '&' : '?')   'nocache=' new Date().getTime();document.head.appendChild(script);</script><div class=\"floating-toolbar\"><div class=\"btn-group\"><a class=\"anchor\" href=\"#anchor-page-top\"><div class=\"floating-btn anchor-top\"><i class=\"fas fa-angle-double-up\"></i></div></a></div><div class=\"btn-group\"><div class=\"floating-btn favorite disabled\"><i class=\"far fa-heart\" title=\"请先登录\"></i></div><script>\n" +
//                 "$(document).ready(function() {\n" +
//                 "    $(\".floating-btn.favorite\").click(function() {\n" +
//                 "        let btn = $(this);\n" +
//                 "        if (btn.hasClass(\"disabled\")) return;\n" +
//                 "        if (btn.hasClass(\"doing\")) return;\n" +
//                 "        btn.addClass(\"doing\");\n" +
//                 "        my.ajax({\n" +
//                 "            action: \"toggleFavorite\",\n" +
//                 "            objMode: \"fiction\",\n" +
//                 "            objId: \"5fb6466e43a25\"\n" +
//                 "        }, function (result) {\n" +
//                 "            btn.removeClass(\"doing\");\n" +
//                 "            if (result.favorited) {\n" +
//                 "                btn.addClass(\"checked\");\n" +
//                 "                btn.find(\"i\").removeClass(\"far\").addClass(\"fas\");\n" +
//                 "            } else {\n" +
//                 "                btn.removeClass(\"checked\");\n" +
//                 "                btn.find(\"i\").removeClass(\"fas\").addClass(\"far\");\n" +
//                 "            }\n" +
//                 "        }, false, true);\n" +
//                 "    });\n" +
//                 "});\n" +
//                 "</script></div><div class=\"btn-group\"><a class=\"anchor\" href=\"#anchor-comment\"><div class=\"floating-btn anchor-comment\"><i class=\"far fa-comments\"></i></div></a></div><div class=\"btn-group\"><a href=\"/fiction/id-5fb6466e43a25.html\"><div data-href=\"/fiction/id-5fb6466e43a25.html\" class=\"floating-btn nav-prev\"><i class=\"fas fa-chevron-left\"></i></div></a><a href=\"/fiction/id-dGhpc19pc19hX2ZpeGVkME1YUjJHSUZOUFUwcFpZbzRvTlVzZFE9PQ==.html\"><div data-href=\"/fiction/id-dGhpc19pc19hX2ZpeGVkME1YUjJHSUZOUFUwcFpZbzRvTlVzZFE9PQ==.html\" class=\"floating-btn nav-next\"><i class=\"fas fa-chevron-right\"></i></div></a><script>\n" +
//                 "$(document).on(\"keydown\", function(event) {\n" +
//                 "    const key = event.key;\n" +
//                 "    if (key !== \"ArrowLeft\" && key !== \"ArrowRight\") return;\n" +
//                 "    const target = event.target;\n" +
//                 "    const tagName = target.tagName.toLowerCase();\n" +
//                 "    if ([\"input\", \"textarea\", \"select\"].includes(tagName)) return;\n" +
//                 "    if (target.contentEditable === 'true' || target.isContentEditable) return;\n" +
//                 "    if ($(\".lg-img-wrap\").is(\":visible\")) return;\n" +
//                 "    let btn;\n" +
//                 "    if (key === \"ArrowLeft\") {\n" +
//                 "        btn = $(\".floating-btn.nav-prev\");\n" +
//                 "    } else if (key === \"ArrowRight\") {\n" +
//                 "        btn = $(\".floating-btn.nav-next\");\n" +
//                 "    }\n" +
//                 "    if (btn) {\n" +
//                 "        btn.addClass(\"hover\");\n" +
//                 "        setTimeout(function() {\n" +
//                 "            let url = btn.data(\"href\");\n" +
//                 "            if (url != undefined) {\n" +
//                 "                if (!url.includes('#')) url  = '#anchor-page-top';\n" +
//                 "                window.location.href = url;\n" +
//                 "            }\n" +
//                 "        }, 120);\n" +
//                 "        event.preventDefault();\n" +
//                 "    }\n" +
//                 "});\n" +
//                 "</script></div></div><script>\n" +
//                 "$(function () {\n" +
//                 "    $('.floating-toolbar a.anchor').click(function(e) {\n" +
//                 "        let target = $(this).attr('href');\n" +
//                 "        if (target && target.startsWith('#')) {\n" +
//                 "            let el = $(target);\n" +
//                 "            if (el.length) {\n" +
//                 "                    e.preventDefault();\n" +
//                 "                    let navHeight = $('nav.pc').outerHeight() || 0;\n" +
//                 "                    let top = el.offset().top - navHeight;\n" +
//                 "                    $('html, body').animate({\n" +
//                 "                        scrollTop: top\n" +
//                 "                    }, 500);\n" +
//                 "                }\n" +
//                 "            }\n" +
//                 "        });\n" +
//                 "    });\n" +
//                 "</script>\n" +
//                 "<script>(function(){function c(){var b=a.contentDocument||a.contentWindow.document;if(b){var d=b.createElement('script');d.innerHTML=\"window.__CF$cv$params={r:'997166b2e9773d9e',t:'MTc2MTg5NTM0NQ=='};var a=document.createElement('script');a.src='/cdn-cgi/challenge-platform/scripts/jsd/main.js';document.getElementsByTagName('head')[0].appendChild(a);\";b.getElementsByTagName('head')[0].appendChild(d)}}if(document.body){var a=document.createElement('iframe');a.height=1;a.width=1;a.style.position='absolute';a.style.top=0;a.style.left=0;a.style.border='none';a.style.visibility='hidden';document.body.appendChild(a);if('loading'!==document.readyState)c();else if(window.addEventListener)document.addEventListener('DOMContentLoaded',c);else{var e=document.onreadystatechange||function(){};document.onreadystatechange=function(b){e(b);'loading'!==document.readyState&&(document.onreadystatechange=e,c())}}}})();</script></body>\n" +
//                 "</html>";
//     }
//
//     //
//     //     "有文本“<div class=\"fiction-overview-info-item author\"> 作者： <span>棒棒毛子</span> </div>”和文本“<div class=\"fiction-overview-info-item author\"> 作者： <a href=\"/fictions/keyword-棒棒毛子.html\">棒棒毛子</a> </div>”"
//     // }
// }
