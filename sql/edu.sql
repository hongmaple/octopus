-- ----------------------------
-- Table structure for edu_class
-- ----------------------------
DROP TABLE IF EXISTS `edu_class`;
CREATE TABLE `edu_class` (
                             `class_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
                             `class_name` varchar(32) NOT NULL COMMENT '班级名',
                             `class_Date` date NOT NULL COMMENT '开班时间',
                             `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
                             `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                             `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                             `class_Major` bigint(20) NOT NULL COMMENT '班级专业id',
                             PRIMARY KEY (`class_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='班级信息表';


-- ----------------------------
-- Table structure for edu_classroom
-- ----------------------------
DROP TABLE IF EXISTS `edu_classroom`;
CREATE TABLE `edu_classroom` (
                                 `Classroom_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '教室ID',
                                 `Classroom_address` varchar(255) NOT NULL COMMENT '教室地址',
                                 `Classroom_capacity` int(255) NOT NULL DEFAULT '0' COMMENT '教室容量 单位人',
                                 `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                 `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
                                 `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                 `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                 PRIMARY KEY (`Classroom_id`,`Classroom_capacity`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='教室表';

-- ----------------------------
-- Table structure for edu_class_course
-- ----------------------------
DROP TABLE IF EXISTS `edu_class_course`;
CREATE TABLE `edu_class_course` (
                                    `class_course_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '班级课程ID',
                                    `class_course_class_id` bigint(20) NOT NULL COMMENT '班级ID',
                                    `class_course_teacherid` bigint(20) NOT NULL COMMENT '任课教师id',
                                    `class_course_course_id` bigint(20) NOT NULL COMMENT '课程ID',
                                    `create_by` varchar(64) DEFAULT NULL COMMENT '创建者（只能由系统用户设置）',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                    `update_by` varchar(64) DEFAULT NULL COMMENT '修改者',
                                    `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                    `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                    PRIMARY KEY (`class_course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='班级课程表';

-- ----------------------------
-- Table structure for edu_class_teacher
-- ----------------------------
DROP TABLE IF EXISTS `edu_class_teacher`;
CREATE TABLE `edu_class_teacher` (
                                     `class_teacher_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '班级教师ID',
                                     `class_teacher_class_id` bigint(20) NOT NULL COMMENT '班级ID',
                                     `class_teacher_teacher_id` bigint(20) NOT NULL COMMENT '教师ID',
                                     `create_by` varchar(64) NOT NULL COMMENT '创建者（只能由系统用户设置）',
                                     `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                     `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
                                     `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                     `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                     PRIMARY KEY (`class_teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='班级教师表';

-- ----------------------------
-- Table structure for edu_course
-- ----------------------------
DROP TABLE IF EXISTS `edu_course`;
CREATE TABLE `edu_course` (
                              `course_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '课程ID',
                              `course_name` varchar(32) NOT NULL COMMENT '课程名',
                              `create_by` varchar(64) DEFAULT NULL COMMENT '创建者（只能由系统用户设置）',
                              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                              `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
                              `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                              `course_typeid` bigint(20) NOT NULL COMMENT '课程类型ID',
                              `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                              PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='课程表';

-- ----------------------------
-- Table structure for edu_course_type
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_type`;
CREATE TABLE `edu_course_type` (
                                   `course_type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '课程类型ID',
                                   `course_type_name` varchar(32) NOT NULL COMMENT '课程类型名',
                                   `create_by` varchar(64) DEFAULT NULL COMMENT '创建者（只能由系统用户设置）',
                                   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                   `update_by` varchar(64) DEFAULT NULL COMMENT '修改者',
                                   `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                   `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                   PRIMARY KEY (`course_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='课程类型表';

-- ----------------------------
-- Table structure for edu_major
-- ----------------------------
DROP TABLE IF EXISTS `edu_major`;
CREATE TABLE `edu_major` (
                             `Major_studiedId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '专业id',
                             `Major_studiedName` varchar(50) NOT NULL COMMENT '专业名',
                             `Major_describe` varchar(500) DEFAULT NULL COMMENT '专业描述',
                             `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
                             `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                             `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                             PRIMARY KEY (`Major_studiedId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='专业表';

-- ----------------------------
-- Table structure for edu_paper
-- ----------------------------
DROP TABLE IF EXISTS `edu_paper`;
CREATE TABLE `edu_paper` (
                             `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '试卷号',
                             `qty_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '试卷名称',
                             `qty_time` int(10) DEFAULT NULL COMMENT '考试时间',
                             `qty_sing` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '单选题',
                             `qty_muti` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '多选题',
                             `qty_jud` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '判断题',
                             `qty_fill` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '填空题',
                             `qty_ess` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简答题',
                             `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
                             `score` double(30,1) DEFAULT NULL COMMENT '总分',
  `create_by` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8 DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='试卷表';


-- ----------------------------
-- Table structure for edu_question
-- ----------------------------
DROP TABLE IF EXISTS `edu_question`;
CREATE TABLE `edu_question` (
                                `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '题目序号',
                                `type` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '题目类型',
                                `title` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '题目标题',
                                `sel` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '题目选项',
                                `score` double(30,1) NOT NULL COMMENT '题目分值',
  `answer` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '题目答案/关键词',
  `create_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='题库表';

-- ----------------------------
-- Records of edu_question
-- ----------------------------
INSERT INTO `edu_question` VALUES ('1', '0', '正午时分让太阳光垂直照射一个当中有小孔的黑纸板，接收屏上出现一个小圆斑；测量小圆斑的直径和黑纸板到接收屏的距离，可大致推出太阳直径。他掌握的数据是：太阳光传到地球所需的时间、地球的公转周期、万有引力恒量；在最终得出太阳密度的过程中，他用到的物理规律是小孔成像规律和', '牛顿第二定律@万有引力定律@万有引力定律、牛顿第二定律@万有引力定律、牛顿第三定律', '3.0', 'C', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('2', '0', '如右图所示，光滑的水平桌面上有一弹簧振子，弹簧的劲度系数为k.开始时，振子被拉到平衡位置O的右侧A处，此时拉力大小为F，然后轻轻释放振子，振子从初速度为零的状态开始向左运动，经过时间t后第一次到达平衡位置O处，此时振子的速度为v，则在这个过程中振子的平均速度为(　　)', '0@v/2@F/(kt)@不为零的某值，但由题设条件无法求出', '3.0', 'C', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('3', '0', '如图所示，质量为m的物体从半径为R的半球形碗边向碗底滑动，滑到最低点时的速度为v 。若物体滑到最低点时受到的摩擦力是f，则物体与碗的动摩擦因数为  （     ）', 'Ffmg@Ffmg＋mv2R@Ffmg－mv2R@Ffmv2R', '3.0', 'B', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('4', '0', '当你在单杆上做引体向上时，完成一次引体向上动作，估算你消耗的能量最接近的是', '50J@300J@1000J@3000J', '3.0', 'B', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('5', '1', '水滴自高处由静止开始下落，至落地前的过程中遇到水平方向吹来的风，则（    ）', '风速越大，水滴下落的时间越长@风速越大，水滴落地时的瞬时速度越大@水滴着地时的瞬时速度与风速无关@水滴下落的时间与风速无关', '5.0', 'BD', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('6', '1', '两个质量不同的小球，被长度不等的细线悬挂在同一点，并在同一水平面内作匀速圆周运动，如图所示。则两个小球的：  （     ）', '运动周期相等@运动线速度相等@运动角速度相等@向心加速度相等', '5.0', 'AC', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('7', '0', '关于匀速圆周运动,下列说法中正确的是(     )', '线速度的方向保持不变@线速度的大小保持不变@角速度大小不断变化@线速度和角速度都保持不变', '3.0', 'B', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('8', '1', '甲、乙、丙三小球分别位于如图所示的竖直平面内，甲、乙在同一条竖直线上，甲、丙在同一条水平线上，水平面上的P点在丙的正下方，在同一时刻甲、乙、丙开始运动，甲以水平速度v0平抛，乙以水平速度v0沿水平面向右做匀速直线运动，丙做自由落体运动．则（       ）', '若甲、乙、丙三球同时相遇，则一定发生在P点@若甲、丙二球在空中相遇，此时乙球一定在P点@若只有甲、乙二球在水平面上相遇，此时丙球还未着地@无论初速度v0大小如何，甲、乙、丙三球一定会同时在P点相遇', '5.0', 'AB', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('9', '1', '铁路转弯处的弯道半径r是根据地形决定的．弯道处要求外轨比内轨高，其内外轨高度差h的设计不仅与r有关，还与火车在弯道上的行驶速率v有关．下面正确的是（  ）', 'v一定时，r越小则要求h越大@v一定时，r越大则要求h越大@r一定时，v越小则要求h越大@r一定时，v越大则要求h越大', '5.0', 'AD', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('10', '3', '设宇宙射线粒子的能量是其静止能量的k倍．则粒子运动时的质量等于其静止质量的（ ）倍', '', '3.0', 'k', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('11', '3', '质量为60kg的人，不慎从高空支架上跌落。由于弹性安全带的保护，使他悬挂在空中。已知安全带长5米，其缓冲时间为1.5秒，则安全带受到的平均冲力为___________________。', '', '3.0', '1000N', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('12', '3', '在天然放射现象中放出的三种射线，射线均来源于      ', '', '3.0', '原子核', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('13', '3', '如图，一辆质量为4kg的小车以速度2m/s在光滑水平面上运动，一质量为1kg速度为10m/s的物体以俯角为600的方向落到车上并埋在车里的砂中，此时小车的速度为　　　　 。', '', '3.0', '2.6m/s', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('14', '3', '甲、乙两辆完全一样的小车处于光滑水平面上，质量都是M，乙车内用绳吊一质量为0.5M的小球。当乙车静止时，甲车以速度v与乙车相碰，碰后连为一体，则刚碰后瞬间两车的共同速度为______________。', '', '3.0', 'v/2', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('15', '2', '爱因斯坦提出光是一种电磁波；', '', '4.0', '错', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('16', '2', '光的偏振现象说明光是横波；', '', '4.0', '对', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('17', '2', '在α、β、γ这三种射线中，γ射线的穿透能力最强，α射线的电离能力最强', '', '4.0', '对', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('18', '2', '一单摆做简谐运动，摆球相继两次通过同一位置时的速度必相同', '', '4.0', '错', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('19', '2', '相对论认为：真空中的光速在不同惯性参照系中都是相同的。', '', '4.0', '对', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('20', '4', '简述历史上的原子结构模型。', '', '10.0', '道尔顿实心球模型@汤姆逊枣糕模型@卢瑟福行星模型@玻尔量子化轨道@现代电子云模型', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('21', '4', '爱因斯坦在量子论的早期做出了什么样的贡献？', '', '10.0', '普朗克量子理论@光量子理论@解释光电效应', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('22', '4', '简述量子力学的两大派别', '', '10.0', '德布罗意@物质波@波函数@薛定谔波动方程@海森伯@矩阵力学@玻恩@力学算符表示法', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('23', '4', '狭义相对论的两个基本假设是什么？', '', '10.0', '相对性原理@光速不变原理', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('24', '4', '广义相对论的三大验证是什么？', '', '10.0', '水星轨道近日点的反常进动问题@强引力场@时钟@慢@光线在引力场中偏转', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('25', '0', '下列说法正确的是(   )', '某一声波从空气射入水中，其声波的波长将变大@机械波与电磁波都可在真空中传播@机械波在介质中传播一个周期的时间内，波上的质点沿波的传播方向平移一个波长@电磁波和机械波都能发生干涉、衍射现象和多普勒效应，但都不能发生偏振现象', '3.0', 'A', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('26', '1', '振动系统的固有频率为f0，在周期性驱动力的作用下做受迫振动，驱动力的频率为f.若驱动力的振幅保持不变，下列说法正确的是', '当f＜f0时，该振动系统的振幅随f增大而减小@当f＞f0时，该振动系统的振幅随f减小而增大@该振动系统的振动稳定后，振动的频率等于f0@该振动系统的振动稳定后，振动的频率等于f', '5.0', 'BD', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('27', '0', '关于竖直放置的肥皂液形成的薄膜干涉，下述说法中不正确的是(      )', '干涉条纹的产生是由于光在膜的前后两表面反射，形成的两列光波叠加的结果@干涉条纹中的暗纹是由于上述两列反射光的波谷与波谷叠加的结果@干涉条纹是一组等间距的平行线@观察薄膜干涉条纹时，应在入射光的同一侧', '3.0', 'B', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('28', '0', '有以下说法：其中正确的是', '简谐运动是质点所受的合外力总是指向平衡位置且大小恒定的运动．@一列波的波长与障碍物的尺寸相比越大衍射现象就越明显@变化的磁场一定产生变化的电场@X射线是电子流', '3.0', 'B', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('29', '1', '弹簧振子在光滑水平面上做简谐运动，在振子向平衡位置运动的过程中（ ）', '振子所受回复力逐渐减小 @振子位移逐渐减小 @振子速度逐渐减小 @振子加速度逐渐减小 ', '5.0', 'AD', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('30', '0', '分子间同时存在着引力和斥力，当分子间距增加时，分子间的', '引力增加，斥力减小@引力增加，斥力增加@引力减小，斥力减小@引力减小，斥力增加', '3.0', 'C', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('31', '0', '下列叙述中，正确的是', '物体的温度越高，分子热运动就越剧烈，每个分子动能也越大@布朗运动就是液体分子的热运动@一定质量的理想气体从外界吸收热量，其内能可能不变@根据热力学第二定律可知热量能够从高温物体传到低温物体，但不可能从低温物体传到高温物体', '2.0', 'C', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-20 19:48:21', '0');
INSERT INTO `edu_question` VALUES ('32', '1', '下列说法中正确的有', '气缸内的气体具有很大的压强，是因为气体分子间表现为斥力@液体表面具有张力是因为液体表面层的分子间表现为引力@晶体的物理性质具有各向异性是因为晶体内部微粒按一定规律排列的@温度越高的物体，其内能一定越大、分子运动越剧烈', '5.0', 'BC', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('33', '3', '改变物体内能的方式：         ', '', '3.0', '做功', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('34', '3', '理想气体的内能与_________无关', '', '3.0', '体积', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('35', '3', '外界对一定质量的气体做了200J的功，同时气体又向外界放出了80J的热量，则气体的内能     （填“增加”或“减少”）', '', '3.0', '增加', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('36', '2', '雨后天空出现彩虹是光的衍射现象', '', '4.0', '错', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('37', '2', '紫光光子的能量比红光光子的能量大', '', '4.0', '对', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('39', '4', '为什么说19世纪末物理学面临的“危机”引发了近代物理学革命？', '', '10.0', '电子的发现@放射性的发现@以太漂移的探索@普朗克辐射定律@量子假说', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('40', '0', '这样好吗', '不知道@好@不好@无所谓', '3.0', 'B', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('41', '0', '1+1=?', '1@2@3@4', '3.0', 'B', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('42', '3', '2+3=?', '', '5.0', '5', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');
INSERT INTO `edu_question` VALUES ('80', '4', '23+11=？', null, '5.0', '34', 'admin', '2021-03-17 23:43:04', 'admin', '2021-03-17 23:43:04', '0');

-- ----------------------------
-- Table structure for edu_score
-- ----------------------------
DROP TABLE IF EXISTS `edu_score`;
CREATE TABLE `edu_score` (
                             `score_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '课程分数ID',
                             `score_studentid` bigint(20) NOT NULL COMMENT '学生id',
                             `class_course_course_id` bigint(20) NOT NULL COMMENT '班级课程ID',
                             `score` double(30,1) NOT NULL COMMENT '分数',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `describe` varchar(255) DEFAULT NULL COMMENT '考试描述（比如期末测评 等等）',
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='课程学分表';

-- ----------------------------
-- Table structure for edu_student
-- ----------------------------
DROP TABLE IF EXISTS `edu_student`;
CREATE TABLE `edu_student` (
                               `student_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学生信息ID',
                               `student_no` varchar(12) NOT NULL COMMENT '学号（格式：年号+开班时间+4位报名序号）',
                               `student_name` varchar(32) NOT NULL COMMENT '学生名（学生真实姓名）',
                               `sys_user_id` bigint(20) NOT NULL COMMENT '用户id',
                               `student_class` bigint(20) NOT NULL COMMENT '所属班级ID',
                               `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0.在籍1:毕业 2:休学 3:退学）',
                               `student_Majorstudiedid` bigint(20) NOT NULL COMMENT '所学专业id',
                               PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='学生信息表';

-- ----------------------------
-- Table structure for edu_teacher
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher`;
CREATE TABLE `edu_teacher` (
                               `teacher_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '教师信息ID',
                               `teacher_name` varchar(32) NOT NULL COMMENT '用户名（老师真实姓名）',
                               `sys_user_id` bigint(20) NOT NULL COMMENT '用户id',
                               `Education` char(1) DEFAULT NULL COMMENT '学历（0.高中1.大专.2.本科3.研究生）',
                               `academic_title` char(1) DEFAULT NULL COMMENT '职称（0.一级教师，1.二级教师，2.三级教师）',
                               `status` char(1) DEFAULT '0' COMMENT '状态（0.在职 1.离职）',
                               PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='教师信息表';

-- ----------------------------
-- Table structure for edu_teaching_material
-- ----------------------------
DROP TABLE IF EXISTS `edu_teaching_material`;
CREATE TABLE `edu_teaching_material` (
                                         `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                         `file_name` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件名称',
                                         `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件路径',
                                         `create_by` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建者',
                                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                         `update_by` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '更新者',
                                         `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                         `del_flag` char(1) CHARACTER SET utf8 DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='文件表';


-- ----------------------------
-- Table structure for edu_test_records
-- ----------------------------
DROP TABLE IF EXISTS `edu_test_records`;
CREATE TABLE `edu_test_records` (
                                    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                                    `paper_id` bigint(20) DEFAULT NULL COMMENT '试卷id',
                                    `sing_answer_sheet` varchar(500) DEFAULT NULL COMMENT '单选题答题卡',
                                    `muti_answer_sheet` varchar(500) DEFAULT NULL COMMENT '多选题答题卡',
                                    `jud_answer_sheet` varchar(500) DEFAULT NULL COMMENT '判断题答题卡数组',
                                    `fill_answer_sheet` longtext COMMENT '填空题答题卡数组',
                                    `ess_answer_sheet` varchar(500) DEFAULT NULL COMMENT '简答题答题卡数组',
                                    `course_id` bigint(20) DEFAULT NULL COMMENT '课程id',
                                    `describe` varchar(255) DEFAULT NULL COMMENT '描述',
                                    `score` double(30,1) DEFAULT NULL COMMENT '得分',
  `total_points` double(30,1) DEFAULT NULL COMMENT '总分',
  `class_id` bigint(20) DEFAULT NULL COMMENT '所属班级',
  `create_by` varchar(64) DEFAULT NULL COMMENT '答题人/创建者/登录名称',
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标志（0代表存在 2代表删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='考试记录';

-- ----------------------------
-- Table structure for edu_timetable
-- ----------------------------
DROP TABLE IF EXISTS `edu_timetable`;
CREATE TABLE `edu_timetable` (
                                 `Timetable_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '课表id',
                                 `Timetable_starttime` datetime NOT NULL COMMENT '时间区段：开始时间',
                                 `Timetable_Endtime` datetime NOT NULL COMMENT '时间区段：结束时间',
                                 `Timetable_details_id` bigint(20) NOT NULL COMMENT '课表详情id',
                                 `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                                 PRIMARY KEY (`Timetable_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课表';

-- ----------------------------
-- Table structure for edu_timetable_details
-- ----------------------------
DROP TABLE IF EXISTS `edu_timetable_details`;
CREATE TABLE `edu_timetable_details` (
                                         `details_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '课表详情id',
                                         PRIMARY KEY (`details_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课表详细表';

-- ----------------------------
-- 插入字典
-- ---

INSERT INTO `sys_dict_type` VALUES ('11', '学生状态', 'student_status', '0', 'admin', '2020-01-03 12:27:41', 'admin', '2020-01-03 15:02:14', '学生状态列表');
INSERT INTO `sys_dict_type` VALUES ('12', '教师职称', 'teacher_academic_title', '0', 'admin', '2020-01-03 14:58:06', 'admin', '2020-01-03 15:02:05', '教师职称列表');
INSERT INTO `sys_dict_type` VALUES ('13', '教师状态', 'teacher_status', '0', 'admin', '2020-01-03 15:04:26', '', null, '教师状态列表');
INSERT INTO `sys_dict_type` VALUES ('14', '学历', 'Education', '0', 'admin', '2020-01-03 15:09:57', '', null, '学历列表');
INSERT INTO `sys_dict_type` VALUES ('15', '题目类型', 'QuestionTypes', '0', 'admin', '2021-03-18 01:05:55', '', null, '题库的题目分类');


INSERT INTO `sys_dict_data` VALUES ('30', '0', '在籍', '0', 'student_status', null, null, 'Y', '0', 'admin', '2024-08-30 12:33:44', '', null, '在校学生标记');
INSERT INTO `sys_dict_data` VALUES ('31', '1', '毕业', '1', 'student_status', null, null, 'Y', '0', 'admin', '2024-08-30 12:34:53', '', null, '毕业学生标记');
INSERT INTO `sys_dict_data` VALUES ('32', '2', '休学', '2', 'student_status', null, null, 'Y', '0', 'admin', '2024-08-30 12:35:39', '', null, '休学学生标记');
INSERT INTO `sys_dict_data` VALUES ('33', '3', '退学', '3', 'student_status', null, null, 'Y', '0', 'admin', '2024-08-30 12:36:24', '', null, '退学学生标记');
INSERT INTO `sys_dict_data` VALUES ('34', '0', '一级教师', '0', 'teacher_academic_title', null, null, 'Y', '0', 'admin', '2024-08-30 15:00:05', '', null, '一级教师，等级是最小的');
INSERT INTO `sys_dict_data` VALUES ('35', '1', '二级教师', '1', 'teacher_academic_title', null, null, 'Y', '0', 'admin', '2024-08-30 15:00:52', '', null, '等级为中');
INSERT INTO `sys_dict_data` VALUES ('36', '2', '三级教师', '2', 'teacher_academic_title', null, null, 'Y', '0', 'admin', '2024-08-30 15:01:44', '', null, '最高级教师');
INSERT INTO `sys_dict_data` VALUES ('37', '0', '在职', '0', 'teacher_status', null, null, 'Y', '0', 'admin', '2024-08-30 15:05:37', '', null, '在职标志');
INSERT INTO `sys_dict_data` VALUES ('38', '1', '离职', '1', 'teacher_status', null, null, 'Y', '0', 'admin', '2024-08-30 15:06:07', '', null, '离职标志');
INSERT INTO `sys_dict_data` VALUES ('39', '0', '高中', '0', 'Education', null, null, 'Y', '0', 'admin', '2024-08-30 15:10:46', '', null, '高中学历标识');
INSERT INTO `sys_dict_data` VALUES ('40', '1', '大专', '1', 'Education', null, null, 'Y', '0', 'admin', '2024-08-30 15:11:40', '', null, '大专学历标识');
INSERT INTO `sys_dict_data` VALUES ('41', '2', '本科', '2', 'Education', null, null, 'Y', '0', 'admin', '2024-08-30 15:12:13', '', null, '本科学历标识');
INSERT INTO `sys_dict_data` VALUES ('42', '3', '研究生', '3', 'Education', null, null, 'Y', '0', 'admin', '2024-08-30 15:12:57', '', null, '研究生学历标识');
INSERT INTO `sys_dict_data` VALUES ('43', '1', '单选题', '0', 'QuestionTypes', null, null, 'Y', '0', 'admin', '2021-03-18 01:08:28', '', null, '题目类型');
INSERT INTO `sys_dict_data` VALUES ('44', '2', '多选题', '1', 'QuestionTypes', null, null, 'Y', '0', 'admin', '2021-03-18 01:09:01', '', null, '题目类型');
INSERT INTO `sys_dict_data` VALUES ('45', '3', '判断题', '2', 'QuestionTypes', null, null, 'Y', '0', 'admin', '2021-03-18 01:09:25', '', null, '题目类型');
INSERT INTO `sys_dict_data` VALUES ('46', '4', '填空题', '3', 'QuestionTypes', null, null, 'Y', '0', 'admin', '2021-03-18 01:09:56', '', null, '题目类型');
INSERT INTO `sys_dict_data` VALUES ('47', '5', '简答题', '4', 'QuestionTypes', null, null, 'Y', '0', 'admin', '2021-03-18 01:10:28', '', null, '题目类型');


-- ----------------------------
-- 插入菜单
-- ----------------------------
insert into sys_menu values('1064', '用户信息管理', '0', '1', '#',                '',          'M', '0', '1', '', 'fa fa-gear',           'admin', sysdate(), '', null, '教育目录');
INSERT INTO `sys_menu` VALUES ('1065', '学生信息', '1064', '1', '/edu/student', '', 'C', '0', '0', 'edu:student:view', '#', 'admin', sysdate(), 'ry', sysdate(), '学生信息菜单');
INSERT INTO `sys_menu` VALUES ('1066', '学生信息查询', '1065', '1', '#', '', 'F', '0', '0', 'edu:student:list', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1067', '学生信息新增', '1065', '2', '#', '', 'F', '0', '0', 'edu:student:add', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1068', '学生信息修改', '1065', '3', '#', '', 'F', '0', '0', 'edu:student:edit', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1069', '学生信息删除', '1065', '4', '#', '', 'F', '0', '0', 'edu:student:remove', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1070', '学生信息导出', '1065', '5', '#', '', 'F', '0', '0', 'edu:student:export', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1071', '教师信息', '1064', '1', '/edu/teacher', '', 'C', '0', '0', 'edu:teacher:view', '#', 'admin', sysdate(), 'ry', sysdate(), '教师信息菜单');
INSERT INTO `sys_menu` VALUES ('1072', '教师信息查询', '1071', '1', '#', '', 'F', '0', '0', 'edu:teacher:list', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1073', '教师信息新增', '1071', '2', '#', '', 'F', '0', '0', 'edu:teacher:add', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1074', '教师信息修改', '1071', '3', '#', '', 'F', '0', '0', 'edu:teacher:edit', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1075', '教师信息删除', '1071', '4', '#', '', 'F', '0', '0', 'edu:teacher:remove', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1076', '教师信息导出', '1071', '5', '#', '', 'F', '0', '0', 'edu:teacher:export', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1077', '管理员信息', '1064', '0', '/system/user', 'menuItem', 'C', '0', '0', 'system:user:view', '#', 'admin', sysdate(), 'admin', sysdate(), '管理员信息菜单');
INSERT INTO `sys_menu` VALUES ('1078', '课程分数', '1126', '1', '/edu/score', 'menuItem', 'C', '0', '0', 'edu:score:view', '#', 'admin', sysdate(), 'admin', sysdate(), '课程分数菜单');
INSERT INTO `sys_menu` VALUES ('1079', '课程分数查询', '1078', '1', '#', '', 'F', '0', '0', 'edu:score:list', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1080', '课程分数新增', '1078', '2', '#', '', 'F', '0', '0', 'edu:score:add', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1081', '课程分数修改', '1078', '3', '#', '', 'F', '0', '0', 'edu:score:edit', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1082', '课程分数删除', '1078', '4', '#', '', 'F', '0', '0', 'edu:score:remove', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1083', '课程分数导出', '1078', '5', '#', '', 'F', '0', '0', 'edu:score:export', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1084', '专业管理', '1126', '1', '/edu/major', 'menuItem', 'C', '0', '0', 'edu:major:view', '#', 'admin', sysdate(), 'admin', sysdate(), '专业菜单');
INSERT INTO `sys_menu` VALUES ('1085', '专业查询', '1084', '1', '#', '', 'F', '0', '0', 'edu:major:list', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1086', '专业新增', '1084', '2', '#', '', 'F', '0', '0', 'edu:major:add', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1087', '专业修改', '1084', '3', '#', '', 'F', '0', '0', 'edu:major:edit', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1088', '专业删除', '1084', '4', '#', '', 'F', '0', '0', 'edu:major:remove', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1089', '专业导出', '1084', '5', '#', '', 'F', '0', '0', 'edu:major:export', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1090', '课程类型', '1126', '1', '/edu/CourseType', 'menuItem', 'C', '0', '0', 'edu:CourseType:view', '#', 'admin', sysdate(), 'admin', sysdate(), '课程类型菜单');
INSERT INTO `sys_menu` VALUES ('1091', '课程类型查询', '1090', '1', '#', '', 'F', '0', '0', 'edu:CourseType:list', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1092', '课程类型新增', '1090', '2', '#', '', 'F', '0', '0', 'edu:CourseType:add', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1093', '课程类型修改', '1090', '3', '#', '', 'F', '0', '0', 'edu:CourseType:edit', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1094', '课程类型删除', '1090', '4', '#', '', 'F', '0', '0', 'edu:CourseType:remove', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1095', '课程类型导出', '1090', '5', '#', '', 'F', '0', '0', 'edu:CourseType:export', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1096', '课程管理', '1126', '1', '/edu/course', 'menuItem', 'C', '0', '0', 'edu:course:view', '#', 'admin', sysdate(), 'admin', sysdate(), '班级课程菜单');
INSERT INTO `sys_menu` VALUES ('1097', '课程查询', '1096', '1', '#', '', 'F', '0', '0', 'edu:course:list', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1098', '课程新增', '1096', '2', '#', '', 'F', '0', '0', 'edu:course:add', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1099', '课程修改', '1096', '3', '#', '', 'F', '0', '0', 'edu:course:edit', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1100', '课程删除', '1096', '4', '#', '', 'F', '0', '0', 'edu:course:remove', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1101', '课程导出', '1096', '5', '#', '', 'F', '0', '0', 'edu:course:export', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1102', '教室管理', '1126', '1', '/edu/classroom', 'menuItem', 'C', '0', '0', 'edu:classroom:view', '#', 'admin', sysdate(), 'admin', sysdate(), '教室菜单');
INSERT INTO `sys_menu` VALUES ('1103', '教室查询', '1102', '1', '#', '', 'F', '0', '0', 'edu:classroom:list', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1104', '教室新增', '1102', '2', '#', '', 'F', '0', '0', 'edu:classroom:add', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1105', '教室修改', '1102', '3', '#', '', 'F', '0', '0', 'edu:classroom:edit', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1106', '教室删除', '1102', '4', '#', '', 'F', '0', '0', 'edu:classroom:remove', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1107', '教室导出', '1102', '5', '#', '', 'F', '0', '0', 'edu:classroom:export', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1108', '班级信息', '1126', '1', '/edu/class', 'menuItem', 'C', '0', '0', 'edu:class:view', '#', 'admin', sysdate(), 'admin', sysdate(), '班级信息菜单');
INSERT INTO `sys_menu` VALUES ('1109', '班级信息查询', '1108', '1', '#', '', 'F', '0', '0', 'edu:class:list', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1110', '班级信息新增', '1108', '2', '#', '', 'F', '0', '0', 'edu:class:add', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1111', '班级信息修改', '1108', '3', '#', '', 'F', '0', '0', 'edu:class:edit', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1112', '班级信息删除', '1108', '4', '#', '', 'F', '0', '0', 'edu:class:remove', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1113', '班级信息导出', '1108', '5', '#', '', 'F', '0', '0', 'edu:class:export', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1114', '班级课程', '1126', '1', '/edu/ClassCourse', 'menuItem', 'C', '0', '0', 'edu:ClassCourse:view', '#', 'admin', sysdate(), 'admin', sysdate(), '班级课程菜单');
INSERT INTO `sys_menu` VALUES ('1115', '班级课程查询', '1114', '1', '#', '', 'F', '0', '0', 'edu:ClassCourse:list', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1116', '班级课程新增', '1114', '2', '#', '', 'F', '0', '0', 'edu:ClassCourse:add', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1117', '班级课程修改', '1114', '3', '#', '', 'F', '0', '0', 'edu:ClassCourse:edit', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1118', '班级课程删除', '1114', '4', '#', '', 'F', '0', '0', 'edu:ClassCourse:remove', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1119', '班级课程导出', '1114', '5', '#', '', 'F', '0', '0', 'edu:ClassCourse:export', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1120', '班级教师', '1126', '1', '/edu/ClassTeacher', 'menuItem', 'C', '0', '0', 'edu:ClassTeacher:view', '#', 'admin', sysdate(), 'admin', sysdate(), '班级教师菜单');
INSERT INTO `sys_menu` VALUES ('1121', '班级教师查询', '1120', '1', '#', '', 'F', '0', '0', 'edu:ClassTeacher:list', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1122', '班级教师新增', '1120', '2', '#', '', 'F', '0', '0', 'edu:ClassTeacher:add', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1123', '班级教师修改', '1120', '3', '#', '', 'F', '0', '0', 'edu:ClassTeacher:edit', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1124', '班级教师删除', '1120', '4', '#', '', 'F', '0', '0', 'edu:ClassTeacher:remove', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1125', '班级教师导出', '1120', '5', '#', '', 'F', '0', '0', 'edu:ClassTeacher:export', '#', 'admin', sysdate(), 'ry', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1126', '教务管理', '0', '1', '#', 'menuItem', 'M', '0', '0', null, 'fa fa-bars', 'admin', '2021-03-17 22:25:53', '', null, '');
INSERT INTO `sys_menu` VALUES ('1127', '题库管理', '1126', '1', '/edu/question', 'menuItem', 'C', '0', '0', 'edu:question:view', '#', 'admin', sysdate(), 'admin', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1128', '题目查询', '1127', '1', '#', 'menuItem', 'F', '0', '0', 'edu:question:list', '#', 'admin', sysdate(), 'admin', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1129', '题目新增', '1127', '2', '#', 'menuItem', 'F', '0', '0', 'edu:question:add', '#', 'admin', sysdate(), 'admin', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1130', '题目修改', '1127', '3', '#', 'menuItem', 'F', '0', '0', 'edu:question:edit', '#', 'admin', sysdate(), 'admin', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1131', '题目删除', '1127', '4', '#', 'menuItem', 'F', '0', '0', 'edu:question:remove', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1132', '题目导出', '1127', '5', '#', 'menuItem', 'F', '0', '0', 'edu:question:export', '#', 'admin', sysdate(), 'admin', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1133', '试卷管理', '1126', '1', '/edu/paper', 'menuItem', 'C', '0', '0', 'edu:paper:view', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1134', '试卷查询', '1133', '1', '#', 'menuItem', 'F', '0', '0', 'edu:paper:list', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1135', '新增试卷', '1133', '2', '#', 'menuItem', 'F', '0', '0', 'edu:paper:add', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1136', '修改试卷', '1133', '3', '#', 'menuItem', 'F', '0', '0', 'edu:paper:edit', '#', 'admin', sysdate(), 'admin', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1137', '删除试卷', '1133', '4', '#', 'menuItem', 'F', '0', '0', 'edu:paper:remove', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1138', '导出试卷', '1133', '5', '#', 'menuItem', 'F', '0', '0', 'edu:paper:export', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1139', '考试平台', '1126', '1', '/edu/records', 'menuItem', 'C', '0', '0', 'edu:records:view', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1140', '查询考试', '1139', '1', '#', 'menuItem', 'F', '0', '0', 'edu:records:list', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1141', '导出考试', '1139', '2', '#', 'menuItem', 'F', '0', '0', 'edu:records:export', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1142', '新增考试', '1139', '3', '#', 'menuItem', 'F', '0', '0', 'edu:records:add', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1143', '修改考试', '1139', '4', '#', 'menuItem', 'F', '0', '0', 'edu:records:edit', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1144', '删除考试', '1139', '5', '#', 'menuItem', 'F', '0', '0', 'edu:records:remove', '#', 'admin', sysdate(), 'admin', sysdate(), '');
INSERT INTO `sys_menu` VALUES ('1145', '题目查询', '1133', '6', '#', 'menuItem', 'F', '0', '0', 'edu:question:list', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1146', '题目新增', '1133', '7', '#', 'menuItem', 'F', '0', '0', 'edu:question:add', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1147', '题目修改', '1133', '8', '#', 'menuItem', 'F', '0', '0', 'edu:question:edit', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1148', '题目删除', '1133', '9', '#', 'menuItem', 'F', '0', '0', 'edu:question:remove', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1149', '教学资料', '1126', '1', '/edu/teachingMaterial', 'menuItem', 'C', '0', '0', 'edu:teachingMaterial:view', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1150', '查询资料', '1149', '1', '#', 'menuItem', 'F', '0', '0', 'edu:teachingMaterial:list', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1151', '新增资料', '1149', '2', '#', 'menuItem', 'F', '0', '0', 'edu:teachingMaterial:list', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1152', '修改资料', '1149', '3', '#', 'menuItem', 'F', '0', '0', 'edu:teachingMaterial:edit', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1153', '删除资料', '1149', '4', '#', 'menuItem', 'F', '0', '0', 'edu:teachingMaterial:remove', '#', 'admin', sysdate(), '', null, '');
INSERT INTO `sys_menu` VALUES ('1154', '导出资料', '1149', '5', '#', 'menuItem', 'F', '0', '0', 'edu:teachingMaterial:export', '#', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 初始化-角色和菜单关联表数据
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '1064');
INSERT INTO `sys_role_menu` VALUES ('2', '103');
INSERT INTO `sys_role_menu` VALUES ('2', '104');
INSERT INTO `sys_role_menu` VALUES ('2', '107');
INSERT INTO `sys_role_menu` VALUES ('2', '1016');
INSERT INTO `sys_role_menu` VALUES ('2', '1020');
INSERT INTO `sys_role_menu` VALUES ('2', '1024');
INSERT INTO `sys_role_menu` VALUES ('2', '1035');
INSERT INTO `sys_role_menu` VALUES ('2', '1036');
INSERT INTO `sys_role_menu` VALUES ('2', '1037');
INSERT INTO `sys_role_menu` VALUES ('2', '1038');
INSERT INTO `sys_role_menu` VALUES ('2', '1065');
INSERT INTO `sys_role_menu` VALUES ('2', '1066');
INSERT INTO `sys_role_menu` VALUES ('2', '1070');
INSERT INTO `sys_role_menu` VALUES ('2', '1071');
INSERT INTO `sys_role_menu` VALUES ('2', '1072');
INSERT INTO `sys_role_menu` VALUES ('2', '1076');
INSERT INTO `sys_role_menu` VALUES ('2', '1078');
INSERT INTO `sys_role_menu` VALUES ('2', '1079');
INSERT INTO `sys_role_menu` VALUES ('2', '1080');
INSERT INTO `sys_role_menu` VALUES ('2', '1081');
INSERT INTO `sys_role_menu` VALUES ('2', '1082');
INSERT INTO `sys_role_menu` VALUES ('2', '1083');
INSERT INTO `sys_role_menu` VALUES ('2', '1084');
INSERT INTO `sys_role_menu` VALUES ('2', '1085');
INSERT INTO `sys_role_menu` VALUES ('2', '1086');
INSERT INTO `sys_role_menu` VALUES ('2', '1087');
INSERT INTO `sys_role_menu` VALUES ('2', '1088');
INSERT INTO `sys_role_menu` VALUES ('2', '1089');
INSERT INTO `sys_role_menu` VALUES ('2', '1126');
INSERT INTO `sys_role_menu` VALUES ('2', '1127');
INSERT INTO `sys_role_menu` VALUES ('2', '1128');
INSERT INTO `sys_role_menu` VALUES ('2', '1129');
INSERT INTO `sys_role_menu` VALUES ('2', '1130');
INSERT INTO `sys_role_menu` VALUES ('2', '1131');
INSERT INTO `sys_role_menu` VALUES ('2', '1132');
INSERT INTO `sys_role_menu` VALUES ('2', '1133');
INSERT INTO `sys_role_menu` VALUES ('2', '1134');
INSERT INTO `sys_role_menu` VALUES ('2', '1135');
INSERT INTO `sys_role_menu` VALUES ('2', '1136');
INSERT INTO `sys_role_menu` VALUES ('2', '1137');
INSERT INTO `sys_role_menu` VALUES ('2', '1138');
INSERT INTO `sys_role_menu` VALUES ('2', '1139');
INSERT INTO `sys_role_menu` VALUES ('2', '1140');
INSERT INTO `sys_role_menu` VALUES ('2', '1141');
INSERT INTO `sys_role_menu` VALUES ('2', '1142');
INSERT INTO `sys_role_menu` VALUES ('2', '1143');
INSERT INTO `sys_role_menu` VALUES ('2', '1144');
INSERT INTO `sys_role_menu` VALUES ('2', '1145');
INSERT INTO `sys_role_menu` VALUES ('2', '1146');
INSERT INTO `sys_role_menu` VALUES ('2', '1147');
INSERT INTO `sys_role_menu` VALUES ('2', '1148');
INSERT INTO `sys_role_menu` VALUES ('2', '1149');
INSERT INTO `sys_role_menu` VALUES ('2', '1150');
INSERT INTO `sys_role_menu` VALUES ('2', '1151');
INSERT INTO `sys_role_menu` VALUES ('2', '1152');
INSERT INTO `sys_role_menu` VALUES ('2', '1153');
INSERT INTO `sys_role_menu` VALUES ('2', '1154');
INSERT INTO `sys_role_menu` VALUES ('3', '1');
INSERT INTO `sys_role_menu` VALUES ('3', '1064');
INSERT INTO `sys_role_menu` VALUES ('3', '1071');
INSERT INTO `sys_role_menu` VALUES ('3', '1072');
INSERT INTO `sys_role_menu` VALUES ('3', '1078');
INSERT INTO `sys_role_menu` VALUES ('3', '1079');
INSERT INTO `sys_role_menu` VALUES ('3', '1083');
INSERT INTO `sys_role_menu` VALUES ('3', '1084');
INSERT INTO `sys_role_menu` VALUES ('3', '1085');
INSERT INTO `sys_role_menu` VALUES ('3', '1089');
INSERT INTO `sys_role_menu` VALUES ('3', '1090');
INSERT INTO `sys_role_menu` VALUES ('3', '1091');
INSERT INTO `sys_role_menu` VALUES ('3', '1095');
INSERT INTO `sys_role_menu` VALUES ('3', '1096');
INSERT INTO `sys_role_menu` VALUES ('3', '1097');
INSERT INTO `sys_role_menu` VALUES ('3', '1101');
INSERT INTO `sys_role_menu` VALUES ('3', '1102');
INSERT INTO `sys_role_menu` VALUES ('3', '1103');
INSERT INTO `sys_role_menu` VALUES ('3', '1107');
INSERT INTO `sys_role_menu` VALUES ('3', '1108');
INSERT INTO `sys_role_menu` VALUES ('3', '1109');
INSERT INTO `sys_role_menu` VALUES ('3', '1113');
INSERT INTO `sys_role_menu` VALUES ('3', '1114');
INSERT INTO `sys_role_menu` VALUES ('3', '1115');
INSERT INTO `sys_role_menu` VALUES ('3', '1119');
INSERT INTO `sys_role_menu` VALUES ('3', '1120');
INSERT INTO `sys_role_menu` VALUES ('3', '1121');
INSERT INTO `sys_role_menu` VALUES ('3', '1125');
INSERT INTO `sys_role_menu` VALUES ('3', '1126');
INSERT INTO `sys_role_menu` VALUES ('3', '1127');
INSERT INTO `sys_role_menu` VALUES ('3', '1128');
INSERT INTO `sys_role_menu` VALUES ('3', '1132');
INSERT INTO `sys_role_menu` VALUES ('3', '1133');
INSERT INTO `sys_role_menu` VALUES ('3', '1134');
INSERT INTO `sys_role_menu` VALUES ('3', '1138');
INSERT INTO `sys_role_menu` VALUES ('3', '1139');
INSERT INTO `sys_role_menu` VALUES ('3', '1140');
INSERT INTO `sys_role_menu` VALUES ('3', '1141');
INSERT INTO `sys_role_menu` VALUES ('3', '1142');
INSERT INTO `sys_role_menu` VALUES ('3', '1145');
INSERT INTO `sys_role_menu` VALUES ('3', '1149');
INSERT INTO `sys_role_menu` VALUES ('3', '1150');
INSERT INTO `sys_role_menu` VALUES ('3', '1154');

