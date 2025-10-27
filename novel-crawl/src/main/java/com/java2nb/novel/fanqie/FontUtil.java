package com.java2nb.novel.fanqie;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;

import java.util.Map;

public class FontUtil {
    private static final Map<String, String> dict = toMap(getStr2());


    public static String decode(String str) {
        var result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            var c = str.charAt(i);
            var s = String.valueOf((int) c);
            var ss = String.valueOf(c);
            result.append(dict.getOrDefault(s, ss));
        }
        return result.toString();
    }

    public static Map<String, String> toMap(String s) {
        return JSON.parseObject(s, new TypeReference<Map<String, String>>() {
        });
    }

    public static String getStr2() {
        var s = "{'58344.jpg': 'd', '58345.jpg': '在', '58346.jpg': '主', '58347.jpg': '特', '58348.jpg': '家', '58349.jpg': '军', '58350.jpg': '然', '58351.jpg': '表', '58352.jpg': '场', '58353.jpg': '4', '58354.jpg': '要', '58355.jpg': '只', '58356.jpg': 'v', '58357.jpg': '和', '58359.jpg': '6', '58360.jpg': '别', '58361.jpg': '还', '58362.jpg': 'g', '58363.jpg': '现', '58364.jpg': '儿', '58365.jpg': '岁', '58368.jpg': '此', '58369.jpg': '象', '58370.jpg': '月', '58371.jpg': '3', '58372.jpg': '出', '58373.jpg': '战', '58374.jpg': '工', '58375.jpg': '相', '58376.jpg': 'o', '58377.jpg': '男', '58378.jpg': '直', '58379.jpg': '失', '58380.jpg': '世', '58381.jpg': 'F', '58382.jpg': '都', '58383.jpg': '平', '58384.jpg': '文', '58385.jpg': '什', '58386.jpg': 'v', '58387.jpg': 'o', '58388.jpg': '将', '58389.jpg': '真', '58390.jpg': 't', '58391.jpg': '那', '58392.jpg': '当', '58394.jpg': '会', '58395.jpg': '立', '58396.jpg': '些', '58397.jpg': 'u', '58398.jpg': '是', '58399.jpg': '十', '58400.jpg': '张', '58401.jpg': '学', '58402.jpg': '气', '58403.jpg': '大', '58404.jpg': '爱', '58405.jpg': '两', '58406.jpg': '命', '58407.jpg': '全', '58408.jpg': '后', '58409.jpg': '东', '58410.jpg': '性', '58411.jpg': '通', '58412.jpg': '被', '58413.jpg': '1', '58414.jpg': '它', '58415.jpg': '乐', '58416.jpg': '接', '58417.jpg': '而', '58418.jpg': '感', '58419.jpg': '车', '58420.jpg': '山', '58421.jpg': '公', '58422.jpg': '了', '58423.jpg': '常', '58424.jpg': '以', '58425.jpg': '何', '58426.jpg': '可', '58427.jpg': '话', '58428.jpg': '先', '58429.jpg': 'p', '58430.jpg': 'i', '58431.jpg': '叫', '58432.jpg': '轻', '58433.jpg': 'm', '58434.jpg': '土', '58435.jpg': 'w', '58436.jpg': '着', '58437.jpg': '变', '58438.jpg': '尔', '58439.jpg': '快', '58440.jpg': 'l', '58441.jpg': '个', '58442.jpg': '说', '58443.jpg': '少', '58444.jpg': '色', '58445.jpg': '里', '58446.jpg': '安', '58447.jpg': '花', '58448.jpg': '远', '58449.jpg': '7', '58450.jpg': '难', '58451.jpg': '师', '58452.jpg': '放', '58453.jpg': 't', '58454.jpg': '报', '58455.jpg': '认', '58456.jpg': '面', '58457.jpg': '道', '58458.jpg': 's', '58460.jpg': '克', '58461.jpg': '地', '58462.jpg': '度', '58463.jpg': 'l', '58464.jpg': '好', '58465.jpg': '机', '58466.jpg': 'U', '58467.jpg': '民', '58468.jpg': '写', '58469.jpg': '把', '58470.jpg': '万', '58471.jpg': '同', '58472.jpg': '水', '58473.jpg': '新', '58474.jpg': '没', '58475.jpg': '书', '58476.jpg': '电', '58477.jpg': '吃', '58478.jpg': '像', '58479.jpg': '斯', '58480.jpg': '5', '58481.jpg': '为', '58482.jpg': 'y', '58483.jpg': '自', '58484.jpg': '几', '58485.jpg': '日', '58486.jpg': '教', '58487.jpg': '看', '58488.jpg': '但', '58489.jpg': '第', '58490.jpg': '加', '58491.jpg': '候', '58492.jpg': '作', '58493.jpg': '上', '58494.jpg': '拉', '58495.jpg': '住', '58496.jpg': '有', '58497.jpg': '法', '58498.jpg': 'r', '58499.jpg': '事', '58500.jpg': '应', '58501.jpg': '位', '58502.jpg': '利', '58503.jpg': '你', '58504.jpg': '声', '58505.jpg': '身', '58506.jpg': '国', '58507.jpg': '问', '58508.jpg': '马', '58509.jpg': '女', '58510.jpg': '他', '58511.jpg': 'y', '58512.jpg': '比', '58513.jpg': '父', '58514.jpg': 'x', '58515.jpg': 'a', '58516.jpg': 'H', '58517.jpg': 'N', '58518.jpg': 's', '58519.jpg': 'x', '58520.jpg': '边', '58521.jpg': '美', '58522.jpg': '对', '58523.jpg': '所', '58524.jpg': '金', '58525.jpg': '活', '58526.jpg': '回', '58527.jpg': '意', '58528.jpg': '到', '58529.jpg': 'z', '58530.jpg': '从', '58531.jpg': 'j', '58532.jpg': '知', '58533.jpg': '又', '58534.jpg': '内', '58535.jpg': '因', '58536.jpg': '点', '58537.jpg': 'Q', '58538.jpg': '三', '58539.jpg': '定', '58540.jpg': '8', '58541.jpg': 'r', '58542.jpg': 'b', '58543.jpg': '正', '58544.jpg': '或', '58545.jpg': '夫', '58546.jpg': '向', '58547.jpg': '德', '58548.jpg': '听', '58549.jpg': '更', '58551.jpg': '得', '58552.jpg': '告', '58553.jpg': '并', '58554.jpg': '本', '58555.jpg': 'q', '58556.jpg': '过', '58557.jpg': '记', '58558.jpg': 'L', '58559.jpg': '让', '58560.jpg': '打', '58561.jpg': 'f', '58562.jpg': '人', '58563.jpg': '就', '58564.jpg': '者', '58565.jpg': '去', '58566.jpg': '原', '58567.jpg': '满', '58568.jpg': '体', '58569.jpg': '做', '58570.jpg': '经', '58571.jpg': 'k', '58572.jpg': '走', '58573.jpg': '如', '58574.jpg': '孩', '58575.jpg': 'c', '58576.jpg': 'g', '58577.jpg': '给', '58578.jpg': '使', '58579.jpg': '物', '58581.jpg': '最', '58582.jpg': '笑', '58583.jpg': '部', '58585.jpg': '员', '58586.jpg': '等', '58587.jpg': '受', '58588.jpg': 'k', '58589.jpg': '行', '58590.jpg': '一', '58591.jpg': '条', '58592.jpg': '果', '58593.jpg': '动', '58594.jpg': '光', '58595.jpg': '门', '58596.jpg': '头', '58597.jpg': '见', '58598.jpg': '往', '58599.jpg': '自', '58600.jpg': '解', '58601.jpg': '成', '58602.jpg': '处', '58603.jpg': '天', '58604.jpg': '能', '58605.jpg': '于', '58606.jpg': '名', '58607.jpg': '其', '58608.jpg': '发', '58609.jpg': '总', '58610.jpg': '母', '58611.jpg': '的', '58612.jpg': '死', '58613.jpg': '手', '58614.jpg': '入', '58615.jpg': '路', '58616.jpg': '进', '58617.jpg': '心', '58618.jpg': '来', '58619.jpg': 'h', '58620.jpg': '时', '58621.jpg': '力', '58622.jpg': '多', '58623.jpg': '开', '58624.jpg': '已', '58625.jpg': '许', '58626.jpg': 'd', '58627.jpg': '至', '58628.jpg': '由', '58629.jpg': '很', '58630.jpg': '界', '58631.jpg': 'n', '58632.jpg': '小', '58633.jpg': '与', '58634.jpg': 'z', '58635.jpg': '想', '58636.jpg': '代', '58637.jpg': '么', '58638.jpg': '分', '58639.jpg': '生', '58640.jpg': '口', '58641.jpg': '再', '58642.jpg': '妈', '58643.jpg': '望', '58644.jpg': '次', '58645.jpg': '西', '58646.jpg': '风', '58647.jpg': '种', '58648.jpg': '带', '58649.jpg': 'J', '58651.jpg': '实', '58652.jpg': '情', '58653.jpg': '才', '58654.jpg': '这', '58656.jpg': 'e', '58657.jpg': '我', '58658.jpg': '神', '58659.jpg': '格', '58660.jpg': '长', '58661.jpg': '觉', '58662.jpg': '间', '58663.jpg': '年', '58664.jpg': '眼', '58665.jpg': '无', '58666.jpg': '不', '58667.jpg': '亲', '58668.jpg': '关', '58669.jpg': '结', '58670.jpg': '0', '58671.jpg': '友', '58672.jpg': '信', '58673.jpg': '下', '58674.jpg': '却', '58675.jpg': '重', '58676.jpg': '己', '58677.jpg': '老', '58678.jpg': '2', '58679.jpg': '音', '58680.jpg': '字', '58681.jpg': 'm', '58682.jpg': '呢', '58683.jpg': '明', '58684.jpg': '之', '58685.jpg': '前', '58686.jpg': '高', '58687.jpg': 'p', '58688.jpg': 'b', '58689.jpg': '目', '58690.jpg': '太', '58691.jpg': 'e', '58692.jpg': '9', '58693.jpg': '起', '58694.jpg': '棱', '58695.jpg': '她', '58696.jpg': '也', '58697.jpg': 'w', '58698.jpg': '用', '58699.jpg': '方', '58700.jpg': '子', '58701.jpg': '英', '58702.jpg': '每', '58703.jpg': '理', '58704.jpg': '便', '58705.jpg': '四', '58706.jpg': '数', '58707.jpg': '期', '58708.jpg': '中', '58709.jpg': 'c', '58710.jpg': '外', '58711.jpg': '样', '58712.jpg': 'a', '58713.jpg': '海', '58714.jpg': '们', '58715.jpg': '任'}";
        var s2 = s.replace("'", "\"").replace(".jpg", "");
        return s2;
    }

    public static void main(String[] args) {
        var testStr = testStr();
        var realStr = decode(testStr);
        System.out.println(realStr);
    }

    private static String testStr() {
        return "“君临，七\uE527\uE436，\uE521\uE55A\uE474\uE449\uE535\uE3EC伙\uE4F3\uE4BA\uE483\uE487\uE421\uE4F3\uE548\uE40E差\uE52A\uE4FE\uE436，\uE41E\uE4FC\uE47B\uE49E\uE4C5\uE436，\uE51E混元剑\uE487拿\uE444，\uE4C3\uE418\uE41E\uE487\uE4F3兵器吧！”\n" +
                "某\uE449\uE434谷\uE554，\uE4DE\uE485\uE473胡\uE54C\uE535\uE459捋\uE436捋\uE434羊胡，拿\uE404\uE4DE柄剑。\n" +
                "“\uE508\uE54C，\uE487\uE52A\uE41E\uE4DE\uE40A\uE50B\uE3F2\uE51E九阳\uE49C针\uE50D？拿\uE4C5吧！”\n" +
                "另\uE556\uE4DE\uE485穿\uE444青\uE44C\uE524袍\uE4F3\uE535\uE4C4拿\uE404\uE4DE\uE449盒\uE54C，\uE44D\uE458\uE480\uE444九根闪烁\uE444炙热\uE4E2芒\uE4F3\uE49C针。\n" +
                "“君临，\uE51E枚\uE4EB\uE461令\uE487拿\uE444，\uE415遇\uE4A0\uE411\uE50D\uE483，\uE4C3\uE4C5\uE4EB\uE461阁找\uE487\uE474\uE485\uE453兄，\uE48E\uE55A\uE41A罩\uE444\uE487\uE4F3！”\n" +
                "\uE4DE\uE485\uE489穿黑\uE473\uE4DF纹\uE524袍\uE4F3\uE535\uE4C4拿\uE404\uE436\uE4DE枚刻\uE444\uE4EB\uE461二\uE538\uE4F3令牌。\n" +
                "“\uE46A\uE483，君临，谁敢欺负\uE487，\uE487\uE4C3拿\uE444\uE51E北凉王印\uE4C5北凉调集\uE423\uE3ED，诛\uE48E九族！”\n" +
                "\uE4DE\uE485银\uE4F0\uE535\uE4C4\uE40A\uE430掏\uE404\uE4DE枚雕刻\uE444巨蟒\uE4F3\uE423印，\uE4DE脸强势\uE459。\n" +
                "“君临，\uE51E\uE420卡\uE44D\uE480\uE487五\uE453\uE491\uE4F3\uE4DE\uE41C零\uE44F钱，\uE487拿\uE4C5\uE54A，\uE52A够\uE4F3\uE43B\uE4C3拿\uE444龙魂扳指\uE4C5龙氏商\uE41A，\uE417\uE44D\uE4F3钱\uE480\uE4F3\uE41E，随\uE550\uE44F！”\n" +
                "\uE4DE\uE485\uE524\uE4B7充\uE4C7富态，膀\uE423腰圆，\uE4DE双\uE508\uE528睛充\uE4C7财迷\uE407\uE4F3\uE535\uE4C4扔\uE404\uE4DE\uE420黑卡\uE3F5\uE4DE枚扳指，豪\uE422\uE459。\n" +
                "“\uE51E\uE41E暗皇令，君临\uE487拿\uE444，\uE480\uE411\uE50D\uE483，\uE40A\uE430亮\uE404暗皇令，\uE46A\uE4C2敢\uE4E1\uE487！”\n" +
                "随即\uE4DE\uE485\uE489穿黑袍，\uE458\uE44C冷漠，散\uE4F0\uE444阴冷\uE422息\uE4F3\uE535\uE4C4拿\uE404\uE4DE块黑\uE44C令牌，\uE47D\uE458雕刻\uE444\uE4DE\uE449血\uE44C\uE4F3暗\uE538。\n" +
                "“君临，\uE51E玉佩\uE487拿\uE460，\uE531\uE434\uE438\uE428，\uE4BD\uE4B7\uE4C5\uE4DE趟皇埔\uE4DE族，\uE471\uE453\uE3E9\uE417留\uE436\uE460\uE429\uE515\uE4D1\uE487！”\n" +
                "另\uE556\uE4DE\uE485\uE489穿黄袍，\uE458\uE44C深沉\uE4F3\uE535\uE4C4拿\uE404\uE436\uE4DE枚\uE477\uE545\uE4FA精雕细琢\uE4F3玉佩。\n" +
                "“阿弥陀佛！”\n" +
                "“君临，\uE51E颗舍\uE486\uE487拿\uE444，\uE52C键\uE4FC刻\uE480\uE423\uE54A！”\n" +
                "\uE51E\uE4FC，\uE4DE\uE485\uE489穿僧袍，双\uE4F5握\uE444\uE4DE串佛珠\uE4F3\uE535\uE3F5尚\uE4A2怀\uE554拿\uE404\uE436\uE4DE颗\uE49C\uE44C珠\uE54C，\uE417珠\uE54C泛\uE444佛\uE4E2，绝非凡品。\n" +
                "\uE400刻\uE3E9\uE51E\uE434谷\uE554，八\uE485\uE535\uE4C4\uE4AF\uE3E9\uE49A\uE4DE\uE485青\uE527叮嘱\uE459，\uE467\uE4FC\uE414各\uE4E7\uE4F3宝贝\uE40E塞\uE4D1\uE436\uE49A\uE54B。\n" +
                "“君临，\uE531\uE434\uE438\uE428\uE4BD\uE4B7\uE4C5找\uE487\uE417\uE474\uE485\uE453姐，\uE547\uE55A\uE449\uE449\uE43A\uE40E\uE41E\uE48A\uE44C\uE4EB香\uE4F3\uE423\uE499\uE4C2，\uE4C3\uE4DA\uE444\uE487\uE531\uE434\uE4C5祸害\uE53A，\uE4D5\uE460\uE465\uE547\uE55A\uE4D1\uE427收\uE436！”\n" +
                "\uE51E\uE4FC，\uE4DE\uE485\uE489穿\uE473\uE44C\uE524裙，雍容华贵，\uE516姿绰约\uE4F3宫装\uE499\uE4C2\uE49A\uE444青\uE527嘱咐\uE459。\n" +
                "“咳咳，柳\uE4CD烟，\uE487\uE51E\uE44A\uE4F3啥\uE43B啊！”\n" +
                "\uE418即\uE417\uE485\uE473胡\uE54C\uE535\uE459\uE4DE阵咳嗽\uE459。\n" +
                "“哼，\uE521\uE44A错\uE436\uE50D?\uE452\uE52A\uE4E9\uE487\uE55A\uE50B\uE4BF君临\uE3F5\uE487\uE55A\uE474\uE449\uE535\uE4E2棍\uE4DE\uE557\uE418\uE4DE辈\uE54C\uE4F3单\uE489狗\uE50D？”\n" +
                "\uE473衣\uE48D\uE4C2\uE4D1\uE436\uE417\uE473胡\uE54C\uE535\uE459\uE4DE\uE449\uE423\uE473\uE528，怼\uE4F3\uE49A\uE54B\uE529\uE43B\uE43A\uE44A。\n" +
                "“诸\uE485\uE453\uE491，谢谢\uE487\uE55A\uE51E七\uE527\uE4F3\uE476诲，\uE400恩\uE521叶君临\uE46A齿\uE452忘，\uE438\uE428\uE4AB\uE418\uE47A倍\uE49E\uE456！”\n" +
                "叶君临\uE477\uE444九\uE485\uE453\uE491\uE49A\uE4E7\uE534\uE4F3\uE52C\uE4F9，\uE4A6\uE4F9\uE4DE暖，\uE48E\uE40A\uE430\uE531跪\uE4D1九\uE485\uE453\uE491磕\uE436\uE4AA\uE449\uE4E4，\uE3EE\uE428\uE545\uE489\uE531\uE434\uE436。\n" +
                "“潜龙\uE404渊，\uE51E龙\uE48A\uE3F2\uE445\uE4EB\uE436！”\n" +
                "\uE417\uE485\uE489穿黑\uE473\uE4DF纹\uE524袍\uE4F3\uE535\uE4C4\uE528\uE554泛\uE444精芒喃喃\uE4E7语。\n" +
                "\uE431\uE3E9\uE434\uE531\uE4DE\uE4EA\uE435\uE4F7旁，\uE41F\uE474辆商务\uE433\uE414\uE4DE辆宝\uE48C七系\uE4D1\uE53D\uE428堵\uE47F\uE436，\uE431\uE4A2\uE417商务\uE433\uE47D\uE531\uE4FA\uE474\uE41F\uE485\uE489穿黑\uE44C衬衫\uE4F3\uE409\uE54C，\uE4EF\uE554领\uE4E4\uE4F3乃\uE41E\uE4DE\uE485\uE4E2\uE4E4\uE423汉，\uE48E\uE55A\uE40A\uE430\uE414宝\uE48C围\uE47F\uE436。\n" +
                "\uE51E\uE4FC，\uE4A2宝\uE48C\uE433\uE4F3驾驶\uE485\uE47D\uE531\uE4FA\uE4DE\uE485\uE489穿黑\uE44C皮衣，扎\uE444\uE4DE\uE4E4辫\uE54C，\uE489材\uE53E挑，\uE528\uE522凌厉\uE4F3\uE48D\uE54C，\uE477\uE444\uE528\uE53D\uE51E\uE41C\uE4C2：“\uE487\uE55A\uE41E\uE411\uE50D\uE4C2？\uE50B干\uE411\uE50D？”\n" +
                "“姜\uE423\uE508姐，\uE487\uE52A\uE4C0算\uE531\uE433\uE50D？”\n" +
                "\uE4E2\uE4E4\uE423汉\uE477\uE444宝\uE48C\uE433\uE4F3\uE428座冷\uE4D6\uE444。\n" +
                "咔！\n" +
                "宝\uE48C\uE428座\uE433\uE4E3\uE4C0\uE4FF，\n" +
                "\uE4DE\uE485\uE489穿黑\uE44C\uE524裙，\uE518\uE444墨镜，\uE4DE\uE4E4瀑布秀\uE4F0披洒\uE3E9肩\uE4E4\uE4F3\uE48D\uE4C2\uE4CC\uE436\uE531\uE4FA。\n" +
                "\uE51E\uE48D\uE4C2摘\uE531墨镜，露\uE404\uE4DE\uE420精致\uE431\uE4E9熟\uE4F3绝\uE499脸庞，充\uE4C7\uE444\uE53E冷御姐\uE4F3\uE516范，\uE547\uE477\uE444\uE417\uE4E2\uE4E4\uE423汉吐\uE459：“\uE487\uE55A\uE50B\uE4C9\uE411\uE50D？”\n" +
                "\uE4E2\uE4E4\uE423汉\uE477\uE444\uE51E\uE48D\uE4C2冷\uE459：“姜\uE423\uE508姐，今\uE4EB\uE487怕\uE41E\uE49E\uE52A\uE4C5江\uE559\uE436！”\n" +
                "唰唰唰！！！\n" +
                "顿\uE4FC，\uE417群\uE489穿黑\uE44C衬衫\uE4F3\uE409\uE54C\uE427\uE4D7拿\uE404\uE4DE柄柄尖刀，散\uE4F0\uE404冰冷\uE4F3煞\uE422。\n" +
                "\uE431皮衣\uE48D\uE54C\uE522\uE44C\uE4DE\uE445，\uE40A\uE430挡\uE3E9\uE417\uE524裙\uE48D\uE4C2\uE458\uE53D，\uE477\uE444\uE4E2\uE4E4\uE409\uE4C2呵斥\uE459：“\uE487\uE55A\uE460\uE423\uE4F3胆\uE54C，竟敢\uE4E1\uE508姐，\uE487\uE55A\uE52A怕姜氏商\uE41A\uE4F3\uE456复\uE50D？”\n" +
                "“\uE41E徐\uE4EB旺派\uE487\uE55A\uE4FA\uE4F3吧？”\n" +
                "\uE417\uE524裙\uE48D\uE4C2\uE522\uE44C淡漠\uE4F3吐\uE459，\uE4E2\uE4E4\uE423汉\uE458\uE44C微\uE445，\uE459：“姜\uE423\uE508姐，\uE487该\uE47D\uE4F7\uE436，杀！”\n" +
                "\uE418即\uE417群\uE409\uE54C\uE427\uE4D7朝\uE444\uE524裙\uE48D\uE4C2冲\uE4C5，\uE417皮衣\uE48D\uE54C\uE423\uE43F\uE459：“\uE508姐，\uE487\uE447\uE47D\uE433离\uE4FF，\uE521\uE4FA挡\uE47F\uE48E\uE55A！”\n" +
                "皮衣\uE48D\uE54C\uE40A\uE430冲\uE436\uE404\uE4C5，\uE3F5\uE51E群\uE4C2激\uE405\uE3E9\uE4DE\uE545！\n" +
                "砰砰砰！！！\n" +
                "\uE431皮衣\uE48D\uE54C虽\uE471\uE48D\uE54C，\uE478\uE405斗\uE545\uE4FA\uE532\uE41F\uE50E凶猛狠辣，\uE4DE眨\uE528\uE4F3功\uE4B1\uE550\uE454倒\uE436\uE41F\uE474\uE4C2，\uE478随\uE444\uE51E\uE41C\uE4C2\uE4DE涌\uE431\uE47D，皮衣\uE48D\uE54C寡\uE52A敌众，\uE505\uE447\uE550\uE489\uE554\uE552刀，节节败退，\uE4D5\uE428\uE42C\uE4E2\uE4E4\uE423汉\uE4DE拳轰飞\uE404\uE4C5，砸\uE3E9宝\uE48C\uE433\uE489\uE47D吐\uE444血。\n" +
                "唰！\n" +
                "\uE524裙\uE48D\uE4C2\uE477\uE444皮衣\uE48D\uE54C\uE4DB伤，黛眉\uE4DE皱，\uE431\uE4E2\uE4E4\uE423汉\uE477\uE444\uE4EF冷\uE459：“\uE43A惜\uE436，\uE51E\uE50D\uE4DE\uE485\uE499\uE4C2\uE4C3\uE3F2香消玉殒\uE436！”\n" +
                "\uE4E2\uE4E4\uE423汉\uE44A完，\uE4C3\uE3F2\uE49A\uE417\uE524裙\uE48D\uE4C2\uE531\uE4F5，\uE52D\uE4E0\uE4DE\uE459\uE488\uE537突兀响\uE545：“\uE4EC搭\uE449\uE433\uE50D？”\n" +
                "唰唰唰！！！\n" +
                "随\uE444\uE51E\uE459\uE488\uE537响\uE545，\uE417\uE4E2\uE4E4\uE423汉\uE4DA\uE4C2\uE522\uE44C\uE4DE\uE445，纷纷转\uE4E4，\uE550\uE477\uE4A0\uE4DE\uE485青\uE527\uE52A\uE4A4\uE439\uE4FC\uE404\uE3FB\uE3E9\uE51E，\uE4AF\uE41E叶君临。\n" +
                "“\uE4EC搭\uE449\uE433\uE50D，\uE521\uE548\uE4C5江\uE559！”\n" +
                "叶君临\uE477\uE444\uE524裙\uE48D\uE4C2询\uE48B\uE459，\uE431\uE49A\uE54B\uE522\uE44C\uE4DE愣，\uE503\uE4ED\uE417\uE4E2\uE4E4\uE423汉\uE477\uE444叶君临冷哼\uE459：“\uE508\uE54C，\uE487\uE41E脑\uE54C\uE52A\uE4AF\uE437\uE41E\uE50D？\uE477\uE52A懂\uE521\uE55A\uE3E9干\uE50D？\uE3F9\uE50B搭\uE433，\uE521\uE477\uE487\uE41E\uE50B搭\uE4C5\uE45D狱\uE4F3\uE433吧！”\n" +
                "啪！！！\n" +
                "突\uE3EE，\uE4DE\uE459清脆\uE4F3巴掌\uE488响\uE545。\n" +
                "叶君临\uE4DE甩\uE4F5，\uE4DE巴掌\uE40A\uE430扇\uE3E9\uE4E2\uE4E4\uE423汉脸\uE47D，\uE414\uE4EF扇飞\uE404\uE4C5，冷\uE459：“聒噪！”\n" +
                "唰！！！\n" +
                "顿\uE4FC\uE3E9\uE3F0\uE4F3\uE4C2\uE40E\uE41E\uE4DE惊，\uE431\uE417\uE4E2\uE4E4\uE423汉捂\uE444脸，\uE4DE脸狰狞\uE4F3盯\uE444叶君临：“混蛋，\uE487竟敢\uE4C0\uE535\uE54C，\uE4D1\uE521\uE47D，\uE414\uE48E\uE4D1\uE521剁碎\uE436！”\n" +
                "\uE418即\uE417群\uE489穿黑\uE44C衬衫，\uE4F5持尖刀\uE4F3\uE409\uE54C\uE550\uE4DE股脑\uE4F3朝\uE444叶君临冲\uE4C5，\uE52D\uE4E0\uE48E\uE55A\uE3F9未靠近叶君临\uE550诡异\uE4F3飞\uE436\uE404\uE4C5，\uE4DE\uE449\uE449砸\uE3E9\uE45D\uE47D，惨\uE43F连连。\n" +
                "\uE51E\uE4DE幕，\uE40A\uE430\uE4BF\uE417\uE524裙\uE48D\uE4C2\uE3F5皮衣\uE48D\uE54C\uE3F9\uE480\uE417\uE4E2\uE4E4\uE409\uE4C2惊\uE47F\uE436。\n" +
                "“\uE487……”\n" +
                "\uE4E2\uE4E4\uE423汉\uE477\uE444叶君临，\uE4DE\uE4FC\uE52A\uE4A4\uE4CD\uE439\uE49E答，\uE528\uE554露\uE404浓浓\uE4F3恐惧\uE53C\uE44C。\n" +
                "“滚！”\n" +
                "叶君临\uE458\uE529\uE3EF\uE51C\uE4F3喝\uE459。\n" +
                "\uE417\uE4E2\uE4E4\uE423汉\uE40A\uE430\uE4C3溜\uE53C\uE423吉\uE436，\uE431叶君临\uE4FA\uE4A0\uE524裙\uE48D\uE4C2\uE458\uE53D：“\uE521\uE4EC搭\uE487\uE449\uE433\uE50D？”\n" +
                "\uE524裙\uE48D\uE4C2\uE477\uE436\uE477叶君临，\uE528\uE554泛\uE444精芒，\uE459：“\uE43A\uE438！”\n" +
                "咳咳咳！！！\n" +
                "\uE51E\uE4FC，皮衣\uE48D\uE54C\uE4DE阵咳嗽\uE444，\uE458\uE44C泛\uE473，整\uE449\uE4C2流血\uE4BC\uE4FE，\uE445\uE4B7奄奄\uE4DE息。\n" +
                "“\uE508\uE402，\uE487怎\uE50D\uE557？”\uE524裙\uE48D\uE4C2\uE522\uE44C\uE4DE\uE445，\uE477\uE444皮衣\uE48D\uE54C担\uE4F9\uE459。\n" +
                "咻！\n" +
                "突\uE3EE，叶君临\uE4F5\uE4DE挥，\uE4DE根银针\uE40A\uE430扎\uE3E9\uE417皮衣\uE48D\uE54C\uE4F3\uE489\uE47D，\uE428\uE4C4脸\uE44C\uE4DE\uE445，瞪\uE444\uE48E：“\uE487干\uE411\uE50D？”\n" +
                "“\uE52A\uE50B\uE4F4，\uE4C3闭嘴！”\n" +
                "叶君临冷漠\uE459。\n" +
                "皮衣\uE48D\uE54C\uE42C叶君临\uE4DE呵斥，整\uE449\uE4C2\uE40E愣\uE47F\uE436，\uE505\uE447\uE547\uE528\uE554露\uE404惊讶\uE53C\uE44C，\uE3F3\uE4E5\uE547\uE489\uE47D\uE4F3伤\uE510\uE52A仅血止\uE47F\uE436，\uE431且迅速\uE52D痂，\uE4EF\uE422息\uE4B5\uE41E稳\uE4AB\uE436\uE531\uE4FA。\n" +
                "\uE51E\uE4DE幕，\uE4BF\uE524裙\uE48D\uE4C2\uE3F5皮衣\uE48D\uE54C\uE40E\uE41E\uE4DE脸\uE52A\uE43A思议\uE4F3\uE3EF\uE51C。\n" +
                "\uE505\uE447叶君临拔\uE404银针，皮衣\uE48D\uE54C\uE522\uE44C尴尬\uE4F3\uE477\uE444\uE48E：“谢谢！”\n" +
                "“\uE47D\uE433吧！”\n" +
                "叶君临\uE4B9未搭\uE54F皮衣\uE48D\uE54C，\uE40A\uE430坐\uE4A0\uE436宝\uE48C\uE433\uE4F3\uE428座\uE47D。\n" +
                "\uE477\uE4A0\uE4E7\uE534\uE42C\uE529视，皮衣\uE48D\uE54C顿\uE4FC\uE4F9\uE50F\uE52A\uE4C7，\uE547\uE477\uE444叶君临\uE43F\uE459：“\uE417\uE41E\uE508姐坐\uE4F3，\uE487坐\uE53D\uE458\uE4C5！”\n" +
                "“\uE508\uE402，算\uE436！”\n" +
                "\uE524裙\uE48D\uE4C2\uE440\uE488\uE459，\uE548坐\uE4A0\uE436\uE428排，皮衣\uE48D\uE54C则\uE41E\uE49E\uE4A0驾驶\uE485\uE40A\uE430启\uE4E1\uE433\uE54C朝\uE444江\uE559\uE431\uE4C5。\n" +
                "“\uE487\uE460，\uE3F9\uE52A\uE4A4\uE459\uE487\uE43F\uE411\uE50D\uE53A，\uE521\uE43F姜暮歌！”\n" +
                "\uE433\uE47D，\uE524裙\uE48D\uE4C2\uE477\uE444叶君临，询\uE48B\uE459。\n" +
                "“叶君临！”\n" +
                "叶君临吐\uE404\uE4AA\uE449\uE538，\uE431\uE48E\uE44A完\uE4C3闭\uE47D\uE436双眸，显\uE3EE\uE52A\uE50B\uE4FE\uE44A\uE411\uE50D，姜暮歌则\uE41E\uE4FC\uE52A\uE4FC\uE4F3\uE4C0量\uE444叶君临。\n" +
                "随\uE428\uE4CA\uE4BC五六\uE449\uE508\uE4FC\uE4F3\uE433程，\uE48E\uE55A\uE433\uE54C终\uE4ED\uE4FA\uE4A0\uE436江\uE559市区，叶君临\uE40A\uE430\uE531\uE436\uE433。\n" +
                "“叶\uE43C\uE50F，\uE4DA\uE4DE\uE531！”\n" +
                "\uE51E\uE4FC，姜暮歌跟\uE444\uE531\uE433，\uE477\uE444叶君临：“今\uE4EB谢谢\uE487\uE404\uE4F5\uE407救，\uE51E\uE41E\uE521\uE4F3\uE4EE片，\uE487\uE438\uE428\uE3E9江\uE559\uE480\uE55B\uE439需\uE3F2，\uE43A\uE438随\uE4FC\uE4FA找\uE521！”\n" +
                "姜暮歌拿\uE404\uE4DE\uE420\uE4EE片交\uE4D1\uE436叶君临，\uE431叶君临收\uE531\uE550离\uE4FF\uE436。\n" +
                "“\uE508姐，\uE51E\uE3EC伙\uE542傲慢\uE436吧，\uE48E\uE438\uE471\uE48E\uE41E谁啊？”\n" +
                "皮衣\uE48D\uE54C\uE4FA\uE4A0姜暮歌\uE458\uE53D\uE4DE脸愤愤\uE52A\uE40F\uE4F3哼\uE459。\n" +
                "“\uE480\uE4BA\uE483\uE4F3\uE4C2\uE480\uE4A8\uE42A\uE523\uE505\uE4AF\uE437！”\n" +
                "姜暮歌微微\uE4DE\uE4D6，随即\uE4EF\uE522\uE44C\uE4DE凛，\uE528\uE554露\uE404\uE4DE抹冷\uE4E2：“\uE4CC吧，\uE4C5\uE4E5\uE4E5\uE417\uE485\uE52A\uE50B\uE521\uE49E\uE4FA\uE4F3\uE3EC伙吧！”\n" +
                "\uE431\uE400\uE4FC\uE4F3叶君临站\uE3E9江\uE559街\uE4E4，\uE477\uE444\uE528\uE53D\uE51E\uE449熟悉\uE431\uE4A5陌\uE50F\uE4F3城市，\uE440\uE488\uE459：“七\uE527\uE436，终\uE4ED\uE49E\uE4FA\uE436！”\n" +
                "“七\uE527\uE53D，\uE487辱\uE521姐姐，杀\uE521\uE491\uE4F2，灭\uE521\uE427族！”\n" +
                "“\uE51E笔血账，\uE521\uE3F2\uE4BF\uE487百倍，千倍\uE4F3偿\uE3F9！”\n" +
                "\uE400刻，叶君临\uE4F3脑\uE559\uE554浮\uE3FB\uE404\uE4DE\uE485嚣\uE420，强势，霸\uE459，\uE53E\uE53E\uE3E9\uE47D\uE4F3青\uE527\uE489影，\uE4EF双拳紧握，\uE4DE\uE538\uE4DE句\uE4F3喝\uE459。\uE489\uE47D\uE4B5\uE41E散\uE4F0\uE404\uE4DE股恐怖\uE4F3杀伐\uE53C\uE422，\uE40A\uE430\uE414\uE551周\uE4F3空\uE422\uE40E\uE4D1冻\uE52D\uE47F\uE436，\uE4BC\uE4E6\uE4F3\uE4DD\uE4C2\uE40E忍\uE52A\uE47F\uE4C0\uE436\uE4DE\uE449寒颤。\n" +
                "七\uE527\uE53D，叶君临乃\uE41E江\uE559\uE4DE流\uE3EC族叶\uE3EC\uE423\uE44B爷，\uE480\uE444疼\uE424\uE4E7\uE534\uE4F3\uE491\uE4F2\uE3F5姐姐，\uE50F\uE49D\uE4F3\uE41F\uE50E幸福。\n" +
                "\uE478\uE51E\uE4DE切\uE40E\uE3E9七\uE527\uE53D\uE4F3\uE4DE\uE3F0酒\uE41A\uE47D\uE42C彻底\uE4C0破\uE436。\n" +
                "\uE3E9\uE417\uE3F0江\uE559\uE4EE流汇聚\uE4F3酒\uE41A\uE3FB\uE3F0，叶君临\uE4F3姐姐叶\uE4EB歌\uE42C\uE4DE\uE485\uE522秘\uE423\uE44B\uE477\uE47D，\uE4B9欲欺凌，叶君临\uE4E5状\uE40A\uE430冲\uE436\uE47D\uE4C5，\uE52D\uE4E0\uE532\uE42C\uE49A\uE54B\uE4DE巴掌扇飞。\n" +
                "\uE428\uE4FA叶君临\uE491\uE4F2\uE404\uE3FB，\uE4BA\uE50B\uE438叶\uE3EC权势逼迫\uE417\uE485\uE423\uE44B停\uE4F5，\uE52D\uE4E0\uE49A\uE54B\uE532\uE41E\uE52A屑\uE459：“叶\uE3EC？算\uE449\uE411\uE50D\uE429\uE515？\uE4BA\uE44B\uE4BF\uE487\uE55A\uE50F\uE487\uE55A\uE4C3\uE50F，\uE4BF\uE487\uE55A\uE4F4\uE4C3\uE4B7\uE4F4！“\n" +
                "\uE431\uE428\uE417\uE485\uE423\uE44B\uE4B5\uE41E\uE3F2\uE418众凌辱叶君临姐姐，\uE4D5终\uE4EF姐姐\uE52A堪凌辱，咬舌\uE4E7尽，叶君临\uE4F3\uE491\uE4F2\uE4B5\uE41E\uE471救\uE531\uE48D\uE3FC\uE431\uE42C\uE417\uE485\uE423\uE44B\uE4F3\uE4F5\uE531\uE4D1\uE49D\uE49D\uE4C0\uE4F4。\n" +
                "叶君临\uE477\uE4A0\uE4EF姐姐\uE3F5\uE491\uE4F2惨\uE4F4，彻底疯狂\uE436，\uE52A顾\uE4DE切\uE4F3冲\uE4B2\uE417\uE485\uE423\uE44B，\uE532\uE42C\uE49A\uE54B\uE440易\uE4F3踩\uE3E9脚\uE531，羞辱\uE459：“\uE4C3凭\uE487\uE51E\uE50D\uE4DE\uE449废\uE4D3，\uE4BA\uE44B捏\uE4F4\uE487\uE4C3\uE46E\uE41E捏\uE4F4\uE4DE\uE3F3蚂蚁\uE4DE\uE557简单！”\n" +
                "“废\uE436\uE48E\uE551肢，扔\uE4F8\uE559\uE44D，\uE503\uE4ED叶\uE3EC\uE4EF\uE48E\uE4C2，\uE4DE\uE449\uE52A留，\uE427\uE4D7杀\uE436！”\n" +
                "随\uE444\uE417\uE485\uE53E\uE53E\uE3E9\uE47D\uE4F3\uE423\uE44B\uE4DE句\uE43B，叶君临\uE42C\uE4C0断\uE551肢扔\uE4F8\uE436\uE559\uE44D，叶\uE3EC\uE548惨遭灭\uE4E3！\n" +
                "\uE431\uE400\uE4FC叶君临\uE4A7\uE471\uE542\uE4BC愤怒，\uE422息\uE40A\uE430紊乱\uE436，\uE4F5指掐\uE444掌\uE4F9\uE404血\uE436\uE431\uE52A\uE4E7\uE4A4！\n" +
                "呼哧！\n" +
                "叶君临深呼\uE4DE\uE510\uE422，\uE414\uE4A6\uE4F9\uE4F3\uE51C绪\uE4D1压制\uE436\uE531\uE4C5，\uE40A\uE430朝\uE444城南\uE431\uE4C5。";
    }
}
