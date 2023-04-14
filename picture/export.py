import os
from time import sleep

ROOT = '.\CodeRandomThoughts'
output_path = ".\myexport.md"
# java源文件中最后一行必须为单独的空行，否则生成的文件可能会格式有误！

def get_level_1_title(path):
    dir_list = os.listdir(path)
    return list(filter(lambda x: x not in [".idea", "out", "picture", "Test"], dir_list))


def get_level_2_title(path):
    dir_list = os.listdir(path)
    return dir_list


def get_level_3_title(path):
    dir_list = os.listdir(path)
    return dir_list


def write_title_1(index, name):
    with open(output_path, "a", encoding="UTF-8") as f:
        f.write("# {}、{}\n".format(index, name))


def write_title_2(index_1, index_2, name):
    with open(output_path, "a", encoding="UTF-8") as f:
        f.write("## {}.{}、{}\n".format(index_1, index_2, name))


def write_title_3(index_1, index_2, index_3, name):
    with open(output_path, "a", encoding="UTF-8") as f:
        f.write("### {}.{}.{}、{}\n".format(index_1, index_2, index_3, name))


def write_title_4(index_1, index_2, index_3, index_4, name):
    with open(output_path, "a", encoding="UTF-8") as f:
        f.write("#### {}.{}.{}.{}、{}\n".format(index_1, index_2, index_3, index_4, name))


def write_code(java_code):
    with open(output_path, "a", encoding="UTF-8") as f:
        f.write("```java\n")
        f.writelines(java_code)
        f.write("```\n")
        f.write("\n")


def read_4_java(path):
    print("Finish " + path)
    with open(path, "r", encoding="UTF-8") as f:
        java = f.readlines()
        return java


def _init():
    print("初始化文件！")
    f_r = open(output_path, "r", encoding="UTF-8")

    if len(f_r.readlines()) >= 0:
        f_w = open(output_path, "w", encoding="UTF-8")
        f_w.write("[TOC]\n\n")
        f_w.close()

    f_r.close()
    sleep(2)
    print("文件已初始化！")


def main():
    _init()

    index_1 = 1
    level_1_list = get_level_1_title(ROOT)
    for path_1 in level_1_list:
        write_title_1(index_1, path_1)

        index_2 = 1
        level_2_list = get_level_2_title(os.path.join(ROOT, path_1, "src"))
        for path_2 in level_2_list:
            write_title_2(index_1, index_2, path_2)

            index_3 = 1
            level_3_list = get_level_3_title(os.path.join(ROOT, path_1, "src", path_2))
            for path_3 in level_3_list:
                temp_path = os.path.join(ROOT, path_1, "src", path_2, path_3)

                # 如果三级标题是文件夹，表示下一级才是java文件！
                if os.path.isdir(temp_path):
                    write_title_3(index_1, index_2, index_3, path_3)

                    index_4 = 1
                    level_4_list = get_level_3_title(temp_path)
                    for path_4 in level_4_list:
                        temp_path_2 = os.path.join(ROOT, path_1, "src", path_2, path_3, path_4)
                        # 如果四级标题是文件夹，再次进入文件夹！
                        if os.path.isdir(temp_path_2):
                            write_title_4(index_1, index_2, index_3, index_4, path_4)

                            # 到这一级肯定是java文件了！
                            level_5_list = get_level_3_title(temp_path_2)
                            for path_5 in level_5_list:
                                temp_path_3 = os.path.join(ROOT, path_1, "src", path_2, path_3, path_4, path_5)
                                if os.path.isfile(temp_path_3):
                                    write_code(read_4_java(temp_path_3))
                                else:
                                    raise Exception("文件嵌套过多！")

                            index_4 += 1

                        elif os.path.isfile(temp_path_2):
                            write_code(read_4_java(temp_path_2))
                    index_3 += 1

                # 如果三级标题是java文件，写入markdown文档
                elif os.path.isfile(temp_path):
                    write_code(read_4_java(temp_path))

                else:
                    raise Exception("找不到指定文件！")

            index_2 += 1
        index_1 += 1


def walk_test():
    all_java = [(root, files) for root, dirs, files in os.walk(ROOT)
                if not (".idea" in root or "out" in root or "picture" in root or "Test" in root)]
    for root, files in all_java:
        if len(files) == 0:
            continue
        if ".java" not in files[0]:
            continue
        print(root, files)


if __name__ == '__main__':
    main()
    # walk_test()