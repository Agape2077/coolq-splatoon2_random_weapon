package com.example;

import java.util.Random;

import javax.swing.JOptionPane;

import com.sobte.cqp.jcq.entity.CQDebug;
import com.sobte.cqp.jcq.entity.GroupFile;
import com.sobte.cqp.jcq.entity.ICQVer;
import com.sobte.cqp.jcq.entity.IMsg;
import com.sobte.cqp.jcq.entity.IRequest;
import com.sobte.cqp.jcq.event.JcqAppAbstract;

/**
 * 本文件是JCQ插件的主类<br>
 * <br>
 * 
 * 注意修改json中的class来加载主类，如不设置则利用appid加载，最后一个单词自动大写查找<br>
 * 例：appid(com.example.demo) 则加载类 com.example.Demo<br>
 * 文档地址： https://gitee.com/Sobte/JCQ-CoolQ <br>
 * 帖子：https://cqp.cc/t/37318 <br>
 * 辅助开发变量: {@link JcqAppAbstract#CQ CQ}({@link com.sobte.cqp.jcq.entity.CoolQ 酷Q核心操作类}),
 * 			 {@link JcqAppAbstract#CC CC}({@link com.sobte.cqp.jcq.entity.CQCode 酷Q码操作类}),
 * 			   具体功能可以查看文档
 */
public class Demo extends JcqAppAbstract implements ICQVer, IMsg, IRequest {

	Random random = new Random();
    String[] mode = {"ガチエリア/Splat Zones/占点"
            ,"ガチヤグラ/Tower Control/抢塔",
            "ガチホコ/Rain Maker/抢鱼"
            ,"ガチアサリ/Clam Blitz/蛤蜊"
            ,"ナワバリバトル/Turf War/涂地"};
    String[] map = {
    		"アンチョビットゲームズ/Ancho-V Games/位元鳀鱼游戏厂"
            ,"アロワナモール/Arowana Mall/骨舌鱼商场"
            ,"Bバスパーク//Blackbelly Skatepark/黑鲈滑板场"
            ,"モンガラキャンプ场/Camp Triggerfish/鳞鲀露营场"
            ,"アジフライスタジアム/Goby Arena/炸竹䇲鱼体育馆"
            ,"コンブトラック/Humpback Pump Track/昆布特技赛道"
            ,"海女美术大学/Inkblot Art Academy/海女美术大学"
            ,"モズク农园/Kelp Dome/海蕴农园"
            ,"ザトウマーケット/MakoMart/座头鲸市场"
            ,"マンタマリア号/Manta Maria/蝠𫚉玛丽亚号"
            ,"タチウオパーキング/Moray Towers/白带鱼停车场"
            ,"フジツボスポーツクラブ/Musselforge Fitness/藤壶运动俱乐部"
            ,"ホテルニューオートロ/New Albacore Hotel/新大腹肉饭店"
            ,"ショッツル鉱山/Piranha Pit/盐鱼汁矿山"
            ,"ホッケふ头/Port Mackerel/多线鱼码头"
            ,"デボン海洋博物馆/Shellendorf Institute/泥盆纪海洋博物馆"
            ,"ムツゴ楼/Skipper Pavilion/弹涂楼"
            ,"エンガワ河川敷/Snapper Canal/侧缘河滨渠道"
            ,"ガンガゼ野外音楽堂/Starfish Mainstage/海针露天剧场"
            ,"チョウザメ造船/Sturgeon Shipyard/鲟鱼造船厂"
            ,"バッテラストリート/The Reef/鲭鱼寿司街道"
            ,"スメーシーワールド/Wahoo World/醋饭乐园"
            ,"ハコフグ仓库/Walleye Warehouse/箱河豚仓库"
    };
    String[] weapon ={
    		"水管狙/吸盘雷/捶地",
    		"贴牌水管狙/冰壶/背包",
    		"竹筒甲/冰壶/飞弹",
    		"竹筒乙/毒瓶/水球",
    		"竹筒丙/碳酸雷/泡泡",
    		"4K/地雷/雨",
    		"贴牌4k/雷达/泡泡",
    		"镜4K/地雷/雨",
    		"贴牌镜4k/雷达/泡泡",
    		"中狙/三角雷/高压水枪",
    		"贴牌中狙/雨帘/吸管雷",
    		"英雄狙/三角雷/高压水枪",
    		"中镜狙/三角雷/高压水枪",
    		"贴牌中镜狙/雨帘/吸管雷",
    		"黑中镜狙/花洒/仓鼠球",
    		"短狙/锁敌/墨甲",
    		"贴牌短狙/小鸡/仓鼠球",
    		"红短狙/吸盘雷/背包",
    		"毛笔/三角雷/锤地",
    		"贴牌毛笔/地雷/仓鼠球",
    		"永久毛笔/花洒/墨甲",
    		"毛刷/小鸡/背包",
    		"贴牌毛刷/雷达/飞弹",
    		"黑毛刷/吸盘雷/锤子",
    		"英雄毛刷/小鸡/背包",
    		"碳刷/小鸡/雨",
    		"贴牌碳刷/水球/小鸡",
    		"重刷/地雷/高压水枪",
    		"贴牌重刷/三角雷/墨甲",
    		"黑重刷/花洒/元气弹",
    		"钢笔刷/雨帘/三角雷",
    		"贴牌钢笔刷/吸盘雷/飞弹",
    		"中刷/冰壶/锤地",
    		"贴牌中刷/雷达/仓鼠球",
    		"黑中刷/花洒/元气弹",
    		"英雄中刷/冰壶/锤地",
    		"红泡/地雷/三角雷",
    		"贴牌红泡/吸盘雷/背包",
    		"黑红泡/鱼雷/仓鼠球",
    		"长红泡/毒瓶/雨",
    		"贴牌长红泡/雨帘/墨甲",
    		"蜡笔/三角雷/高压水枪",
    		"贴牌蜡笔/冰壶/飞弹",
    		"长热泡/吸盘雷/雨",
    		"贴牌长热泡/冰壶/泡泡",
    		"绿长热泡/水球/飞弹",
    		"热泡/毒瓶/锤地",
    		"贴牌热泡/小鸡/背包",
    		"英雄热泡/毒瓶/锤地",
    		"白泡/三角雷/仓鼠球",
    		"贴牌白泡/地雷/吸盘雷",
    		"黑白泡/碳酸雷/雨",
    		"银喷/吸盘雷/冰壶",
    		"金喷/花洒/仓鼠球",
    		"铜喷/水球/元气弹",
    		"精英枪/锁敌/雨",
    		"贴牌精英枪/吸盘雷/泡泡",
    		"黑精英枪/三角雷/元气弹",
    		"新叶/三角雷/墨甲",
    		"枫叶/小鸡/雨",
    		"落叶/鱼雷/泡泡",
    		"香槟/雨帘/高压水枪",
    		"贴牌香槟/三角雷/泡泡",
    		"52/锁敌/仓鼠球",
    		"贴牌52/冰壶/高压水枪",
    		"黑52/雨帘/元气弹",
    		"96/花洒/墨甲",
    		"贴牌96/雨帘/锤地",
    		"蓝管/毒瓶/飞弹",
    		"贴牌蓝管/水球/高压水枪",
    		"小绿/水球/锤地",
    		"贴牌小绿/三角雷/背包",
    		"黑小绿/吸盘雷/飞弹",
    		"RUSHB/水球/锤地 ",
    		"章鱼小绿/三角雷/背包",
    		"针枪/毒瓶/背包",
    		"贴牌针枪/水球/吸盘雷",
    		"85/吸盘雷/墨甲",
    		"89/小鸡/飞弹",
    		"83/花洒/雨",
    		"喇叭/冰壶/锤地",
    		"贴牌喇叭/雷达/飞弹",
    		"7号喇叭/三角雷/锤子 ",
    		"H3/吸盘雷/墨甲",
    		"贴牌H3/吸盘雷/墨甲",
    		"樱桃H3/雨帘/泡泡",
    		"L3/冰壶/仓鼠球",
    		"L3D/水球/背包 ",
    		"黑L3/雨帘/锤子",
    		"浴缸/雨帘/雨",
    		"/贴牌浴缸/花洒/吸盘雷 ",
    		"绿桶/水球/墨甲",
    		"贴牌绿桶/三角雷/雨",
    		"洗衣机/小鸡/高压水枪",
    		"贴牌洗衣机/索敌/三角雷",
    		"黑洗衣机/碳酸雷/锤地",
    		"红桶/吸盘雷/飞弹",
    		"贴牌红桶/花洒/仓鼠球",
    		"苏打桶/三角雷/水球",
    		"英雄红桶/吸盘雷/飞弹",
    		"重桶（爆炸桶）/花洒/泡泡",
    		"贴牌重桶（贴牌爆炸桶）/锁敌/仓鼠球",
    		"圆珠笔/毒瓶/背包",
    		"贴牌圆珠笔/雷达/雨",
    		"消防栓/小鸡/锤地",
    		"贴牌消防栓/地雷/墨甲",
    		"轻加/水球/飞弹",
    		"贴牌轻加/冰壶/雨",
    		"黑轻加/毒瓶/锤子",
    		"鹦鹉螺/索敌/仓鼠球",
    		"贴牌鹦鹉螺/吸管雷/背包",
    		"重加/花洒/高压水枪",
    		"贴牌重加/雨帘/泡泡",
    		"重加Remix/锁敌/元气弹 ",
    		"英雄加/花洒/高压水枪",
    		"红双/索敌/飞弹",
    		"贴牌红双/三角雷/雨",
    		"525/地雷/背包 ",
    		"贴牌525/雨帘/仓鼠球 ",
    		"黑525/碳酸雷/墨甲 ",
    		"绿双/水球/飞弹",
    		"金双/冰壶/背包",
    		"黑双/吸盘雷/仓鼠球",
    		"英雄双/水球/飞弹",
    		"红牙刷/雷达/吸盘雷",
    		"蓝牙刷/毒瓶/雨",
    		"白牙刷/鱼雷/锤地",
    		"气垫/小鸡/锤地",
    		"贴牌气垫/花洒/小鸡",
    		"间谍伞/地雷/锤地",
    		"贴牌间谍伞/三角雷/仓鼠球",
    		"白间谍伞/鱼雷/墨甲",
    		"雨伞/花洒/雨",
    		"贴牌雨伞/小鸡/三角雷",
    		"英雄伞/花洒/雨",
    		"重伞（帐篷）/雷达/泡泡",
    		"贴牌重伞/雨帘/冰壶",
    		"迷彩重伞/地雷/锤子"
    };
	/**
     * 用main方法调试可以最大化的加快开发效率，检测和定位错误位置<br/>
     * 以下就是使用Main方法进行测试的一个简易案例
     *
     * @param args 系统参数
     */
    public static void main(String[] args) {
        // CQ此变量为特殊变量，在JCQ启动时实例化赋值给每个插件，而在测试中可以用CQDebug类来代替他
        CQ = new CQDebug();//new CQDebug("应用目录","应用名称") 可以用此构造器初始化应用的目录
        CQ.logInfo("[JCQ] TEST Demo", "测试启动");// 现在就可以用CQ变量来执行任何想要的操作了
        // 要测试主类就先实例化一个主类对象
        Demo demo = new Demo();
        // 下面对主类进行各方法测试,按照JCQ运行过程，模拟实际情况
        demo.startup();// 程序运行开始 调用应用初始化方法
        demo.enable();// 程序初始化完成后，启用应用，让应用正常工作
        // 开始模拟发送消息
        // 模拟私聊消息
        // 开始模拟QQ用户发送消息，以下QQ全部编造，请勿添加
        demo.privateMsg(0, 10001, 2234567819L, "随机武器", 0);
        // 模拟群聊消息
        // 开始模拟群聊消息
        demo.groupMsg(0, 10006, 1008611L, 3333333334L, "", "随机武器", 0);
        // ......
        // 依次类推，可以根据实际情况修改参数，和方法测试效果
        // 以下是收尾触发函数
        // demo.disable();// 实际过程中程序结束不会触发disable，只有用户关闭了此插件才会触发
        demo.exit();// 最后程序运行结束，调用exit方法
    }

    /**
     * 打包后将不会调用 请不要在此事件中写其他代码
     *
     * @return 返回应用的ApiVer、Appid
     */
    public String appInfo() {
        // 应用AppID,规则见 http://d.cqp.me/Pro/开发/基础信息#appid
        String AppID = "com.example.demo";// 记住编译后的文件和json也要使用appid做文件名
        /**
         * 本函数【禁止】处理其他任何代码，以免发生异常情况。
         * 如需执行初始化代码请在 startup 事件中执行（Type=1001）。
         */
        return CQAPIVER + "," + AppID;
    }

    /**
     * 酷Q启动 (Type=1001)<br>
     * 本方法会在酷Q【主线程】中被调用。<br>
     * 请在这里执行插件初始化代码。<br>
     * 请务必尽快返回本子程序，否则会卡住其他插件以及主程序的加载。
     *
     * @return 请固定返回0
     */
    public int startup() {
        // 获取应用数据目录(无需储存数据时，请将此行注释)
        //String appDirectory = CQ.getAppDirectory();
        // 返回如：D:\CoolQ\app\com.sobte.cqp.jcq\app\com.example.demo\
        // 应用的所有数据、配置【必须】存放于此目录，避免给用户带来困扰。
        return 0;
    }

    /**
     * 酷Q退出 (Type=1002)<br>
     * 本方法会在酷Q【主线程】中被调用。<br>
     * 无论本应用是否被启用，本函数都会在酷Q退出前执行一次，请在这里执行插件关闭代码。
     *
     * @return 请固定返回0，返回后酷Q将很快关闭，请不要再通过线程等方式执行其他代码。
     */
    public int exit() {
        return 0;
    }

    /**
     * 应用已被启用 (Type=1003)<br>
     * 当应用被启用后，将收到此事件。<br>
     * 如果酷Q载入时应用已被启用，则在 {@link #startup startup}(Type=1001,酷Q启动) 被调用后，本函数也将被调用一次。<br>
     * 如非必要，不建议在这里加载窗口。
     *
     * @return 请固定返回0。
     */
    public int enable() {
        enable = true;
        return 0;
    }

    /**
     * 应用将被停用 (Type=1004)<br>
     * 当应用被停用前，将收到此事件。<br>
     * 如果酷Q载入时应用已被停用，则本函数【不会】被调用。<br>
     * 无论本应用是否被启用，酷Q关闭前本函数都【不会】被调用。
     *
     * @return 请固定返回0。
     */
    public int disable() {
        enable = false;
        return 0;
    }

    /**
     * 私聊消息 (Type=21)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subType 子类型，11/来自好友 1/来自在线状态 2/来自群 3/来自讨论组
     * @param msgId   消息ID
     * @param fromQQ  来源QQ
     * @param msg     消息内容
     * @param font    字体
     * @return 返回值*不能*直接返回文本 如果要回复消息，请调用api发送<br>
     * 这里 返回  {@link IMsg#MSG_INTERCEPT MSG_INTERCEPT} - 截断本条消息，不再继续处理<br>
     * 注意：应用优先级设置为"最高"(10000)时，不得使用本返回值<br>
     * 如果不回复消息，交由之后的应用/过滤器处理，这里 返回  {@link IMsg#MSG_IGNORE MSG_IGNORE} - 忽略本条消息
     */
    public int privateMsg(int subType, int msgId, long fromQQ, String msg, int font) {

        // 这里处理消息
    	if (msg.equals("随机武器")|| msg == "随机武器"){
       	 
            CQ.sendGroupMsg(fromQQ,	"模式：\n"
           		+ mode[random.nextInt(5)]+"\n"
            		+"---------------------------------\n"
           		+ "地图：\n"
           		+ map[random.nextInt(23)]+"\n"
           		+ "---------------------------------\n"
           		+ "Team RED:\n"
           		+ "主武器/服务器/大招\n"
           		+ weapon[random.nextInt(138)]+"\n"
           		+ weapon[random.nextInt(138)]+"\n"
           		+ weapon[random.nextInt(138)]+"\n"
           		+ weapon[random.nextInt(138)]+"\n"
           		+ "---------------------------------\n"
           		+ "Team GREEN:\n"
           		+ "主武器/服务器/大招\n"
           		+ weapon[random.nextInt(138)]+"\n"
           		+ weapon[random.nextInt(138)]+"\n"
           		+ weapon[random.nextInt(138)]+"\n"
           		+ weapon[random.nextInt(138)]+"\n");

       }
    	return MSG_IGNORE;
    }

    /**
     * 群消息 (Type=2)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subType       子类型，目前固定为1
     * @param msgId         消息ID
     * @param fromGroup     来源群号
     * @param fromQQ        来源QQ号
     * @param fromAnonymous 来源匿名者
     * @param msg           消息内容
     * @param font          字体
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int groupMsg(int subType, int msgId, long fromGroup, long fromQQ, String fromAnonymous, String msg,
                        int font) {
        // 如果消息来自匿名者
        if (fromQQ == 80000000L && !fromAnonymous.equals("")) {
            // 将匿名用户信息放到 anonymous 变量中
            //Anonymous anonymous = CQ.getAnonymous(fromAnonymous);
        }

        // 解析CQ码案例 如：[CQ:at,qq=100000]
        // 解析CQ码 常用变量为 CC(CQCode) 此变量专为CQ码这种特定格式做了解析和封装
        // CC.analysis();// 此方法将CQ码解析为可直接读取的对象
        // 解析消息中的QQID
        //long qqId = CC.getAt(msg);// 此方法为简便方法，获取第一个CQ:at里的QQ号，错误时为：-1000
        //List<Long> qqIds = CC.getAts(msg); // 此方法为获取消息中所有的CQ码对象，错误时返回 已解析的数据
        // 解析消息中的图片
        //CQImage image = CC.getCQImage(msg);// 此方法为简便方法，获取第一个CQ:image里的图片数据，错误时打印异常到控制台，返回 null
        //List<CQImage> images = CC.getCQImages(msg);// 此方法为获取消息中所有的CQ图片数据，错误时打印异常到控制台，返回 已解析的数据

        // 这里处理消息
        
        if (msg.equals("随机武器")|| msg == "随机武器")
             CQ.sendGroupMsg(fromGroup,	"模式：\n"
            		+ mode[random.nextInt(5)]+"\n"
             		+"---------------------------------\n"
            		+ "地图：\n"
            		+ map[random.nextInt(23)]+"\n"
            		+ "---------------------------------\n"
            		+ "Team RED:\n"
            		+ "主武器/副武器/大招\n"
            		+ "---------------------------------\n"
            		+ weapon[random.nextInt(80)]+"\n"
            		+ weapon[random.nextInt(80)]+"\n"
            		+ weapon[random.nextInt(80)]+"\n"
            		+ weapon[random.nextInt(80)]+"\n"
            		+ "---------------------------------\n"
            		+ "Team GREEN:\n"
            		+ "主武器/副武器/大招\n"
            		+ "---------------------------------\n"
            		+ weapon[random.nextInt(80)]+"\n"
            		+ weapon[random.nextInt(80)]+"\n"
            		+ weapon[random.nextInt(80)]+"\n"
            		+ weapon[random.nextInt(80)]+"\n"
            		+ "---------------------------------\n"
            		+"玩的开心！");

        
        
        return MSG_IGNORE;
    }

    /**
     * 讨论组消息 (Type=4)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype     子类型，目前固定为1
     * @param msgId       消息ID
     * @param fromDiscuss 来源讨论组
     * @param fromQQ      来源QQ号
     * @param msg         消息内容
     * @param font        字体
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int discussMsg(int subtype, int msgId, long fromDiscuss, long fromQQ, String msg, int font) {
        // 这里处理消息
    	
        return MSG_IGNORE;
    }

    /**
     * 群文件上传事件 (Type=11)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subType   子类型，目前固定为1
     * @param sendTime  发送时间(时间戳)// 10位时间戳
     * @param fromGroup 来源群号
     * @param fromQQ    来源QQ号
     * @param file      上传文件信息
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int groupUpload(int subType, int sendTime, long fromGroup, long fromQQ, String file) {
        GroupFile groupFile = CQ.getGroupFile(file);
        if (groupFile == null) { // 解析群文件信息，如果失败直接忽略该消息
            return MSG_IGNORE;
        }
        // 这里处理消息
        return MSG_IGNORE;
    }

    /**
     * 群事件-管理员变动 (Type=101)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype        子类型，1/被取消管理员 2/被设置管理员
     * @param sendTime       发送时间(时间戳)
     * @param fromGroup      来源群号
     * @param beingOperateQQ 被操作QQ
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int groupAdmin(int subtype, int sendTime, long fromGroup, long beingOperateQQ) {
        // 这里处理消息

        return MSG_IGNORE;
    }

    /**
     * 群事件-群成员减少 (Type=102)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype        子类型，1/群员离开 2/群员被踢
     * @param sendTime       发送时间(时间戳)
     * @param fromGroup      来源群号
     * @param fromQQ         操作者QQ(仅子类型为2时存在)
     * @param beingOperateQQ 被操作QQ
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int groupMemberDecrease(int subtype, int sendTime, long fromGroup, long fromQQ, long beingOperateQQ) {
        // 这里处理消息

        return MSG_IGNORE;
    }

    /**
     * 群事件-群成员增加 (Type=103)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype        子类型，1/管理员已同意 2/管理员邀请
     * @param sendTime       发送时间(时间戳)
     * @param fromGroup      来源群号
     * @param fromQQ         操作者QQ(即管理员QQ)
     * @param beingOperateQQ 被操作QQ(即加群的QQ)
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int groupMemberIncrease(int subtype, int sendTime, long fromGroup, long fromQQ, long beingOperateQQ) {
        // 这里处理消息

        return MSG_IGNORE;
    }

    /**
     * 好友事件-好友已添加 (Type=201)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype  子类型，目前固定为1
     * @param sendTime 发送时间(时间戳)
     * @param fromQQ   来源QQ
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int friendAdd(int subtype, int sendTime, long fromQQ) {
        // 这里处理消息

        return MSG_IGNORE;
    }

    /**
     * 请求-好友添加 (Type=301)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype      子类型，目前固定为1
     * @param sendTime     发送时间(时间戳)
     * @param fromQQ       来源QQ
     * @param msg          附言
     * @param responseFlag 反馈标识(处理请求用)
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int requestAddFriend(int subtype, int sendTime, long fromQQ, String msg, String responseFlag) {
        // 这里处理消息

        /**
         * REQUEST_ADOPT 通过
         * REQUEST_REFUSE 拒绝
         */

        // CQ.setFriendAddRequest(responseFlag, REQUEST_ADOPT, null); // 同意好友添加请求
        return MSG_IGNORE;
    }

    /**
     * 请求-群添加 (Type=302)<br>
     * 本方法会在酷Q【线程】中被调用。<br>
     *
     * @param subtype      子类型，1/他人申请入群 2/自己(即登录号)受邀入群
     * @param sendTime     发送时间(时间戳)
     * @param fromGroup    来源群号
     * @param fromQQ       来源QQ
     * @param msg          附言
     * @param responseFlag 反馈标识(处理请求用)
     * @return 关于返回值说明, 见 {@link #privateMsg 私聊消息} 的方法
     */
    public int requestAddGroup(int subtype, int sendTime, long fromGroup, long fromQQ, String msg,
                               String responseFlag) {
        // 这里处理消息

        /**
         * REQUEST_ADOPT 通过
         * REQUEST_REFUSE 拒绝
         * REQUEST_GROUP_ADD 群添加
         * REQUEST_GROUP_INVITE 群邀请
         */
		/*if(subtype == 1){ // 本号为群管理，判断是否为他人申请入群
			CQ.setGroupAddRequest(responseFlag, REQUEST_GROUP_ADD, REQUEST_ADOPT, null);// 同意入群
		}
		if(subtype == 2){
			CQ.setGroupAddRequest(responseFlag, REQUEST_GROUP_INVITE, REQUEST_ADOPT, null);// 同意进受邀群
		}*/

        return MSG_IGNORE;
    }

    /**
     * 本函数会在JCQ【线程】中被调用。
     *
     * @return 固定返回0
     */
    public int menuA() {
        JOptionPane.showMessageDialog(null, "这是测试菜单A，可以在这里加载窗口");
        return 0;
    }

    /**
     * 本函数会在酷Q【线程】中被调用。
     *
     * @return 固定返回0
     */
    public int menuB() {
        JOptionPane.showMessageDialog(null, "这是测试菜单B，可以在这里加载窗口");
        return 0;
    }

}
