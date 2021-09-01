# 資料來源: https://blog.csdn.net/i_chaoren/article/details/56296713
#======================
# imports
#======================
import os
import tkinter as tk
from tkinter import Menu, Spinbox
from tkinter import messagebox as mBox
from tkinter import scrolledtext, ttk


#由於tkinter中沒有ToolTip功能，所以自定義這個功能如下
class ToolTip(object):
    def __init__(self, widget):
        self.widget = widget
        self.tipwindow = None
        self.id = None
        self.x = self.y = 0

    def showtip(self, text):
        "Display text in tooltip window"
        self.text = text
        if self.tipwindow or not self.text:
            return
        x, y, _cx, cy = self.widget.bbox("insert")
        x = x + self.widget.winfo_rootx() + 27
        y = y + cy + self.widget.winfo_rooty() + 27
        self.tipwindow = tw = tk.Toplevel(self.widget)
        tw.wm_overrideredirect(1)
        tw.wm_geometry("+%d+%d" % (x, y))

        label = tk.Label(tw,
                         text=self.text,
                         justify=tk.LEFT,
                         background="#ffffe0",
                         relief=tk.SOLID,
                         borderwidth=1,
                         font=("tahoma", "8", "normal"))
        label.pack(ipadx=1)

    def hidetip(self):
        tw = self.tipwindow
        self.tipwindow = None
        if tw:
            tw.destroy()


#===================================================================
def createToolTip(widget, text):
    toolTip = ToolTip(widget)

    def enter(event):
        toolTip.showtip(text)

    def leave(event):
        toolTip.hidetip()

    widget.bind('<Enter>', enter)
    widget.bind('<Leave>', leave)


# Create instance
win = tk.Tk()

# Add a title
win.title("Python 圖形用戶界面")

# Disable resizing the GUI
win.resizable(0, 0)

# Tab Control introduced here --------------------------------------
tabControl = ttk.Notebook(win)  # Create Tab Control

tab1 = ttk.Frame(tabControl)  # Create a tab
tabControl.add(tab1, text='第一頁')  # Add the tab

tab2 = ttk.Frame(tabControl)  # Add a second tab
tabControl.add(tab2, text='第二頁')  # Make second tab visible

tab3 = ttk.Frame(tabControl)  # Add a third tab
tabControl.add(tab3, text='第三頁')  # Make second tab visible

tabControl.pack(expand=1, fill="both")  # Pack to make visible
# ~ Tab Control introduced here -----------------------------------------

#---------------Tab1控件介紹------------------#
# We are creating a container tab3 to hold all other widgets
monty = ttk.LabelFrame(tab1, text='控件示範區1', borderwidth=3)
monty.grid(column=0, row=0, padx=8, pady=4)


# Modified Button Click Function
def clickMe():
    action.configure(text='Hello\n ' + name.get())
    action.configure(state='disabled')  # Disable the Button Widget


# Changing our Label
ttk.Label(monty, text="輸入文字:").grid(column=0, row=0, sticky='W')

# Adding a Textbox Entry widget
name = tk.StringVar()
nameEntered = ttk.Entry(monty, width=12, textvariable=name)
nameEntered.grid(column=0, row=1, sticky='W')

# Adding a Button
action = ttk.Button(monty, text="點擊之後\n按鈕失效", width=10, command=clickMe)
action.grid(column=2, row=1, rowspan=2, ipady=7)

ttk.Label(monty, text="請選擇一本書:").grid(column=1, row=0, sticky='W')

# Adding a Combobox
book = tk.StringVar()
bookChosen = ttk.Combobox(monty, width=12, textvariable=book)
bookChosen['values'] = ('平凡的世界', '親愛的安德烈', '看見', '白夜行')
bookChosen.grid(column=1, row=1)
bookChosen.current(0)  #設置初始顯示值，值為元組['values']的下標
bookChosen.config(state='readonly')  #設為只讀模式


# Spinbox callback
def _spin():
    value = spin.get()
    #print(value)
    scr.insert(tk.INSERT, value + '\n')


def _spin2():
    value = spin2.get()
    #print(value)
    scr.insert(tk.INSERT, value + '\n')


# Adding 2 Spinbox widget using a set of values
spin = Spinbox(monty, from_=10, to=25, width=5, bd=8, command=_spin)
spin.grid(column=0, row=2)

spin2 = Spinbox(monty,
                values=('Python3入門', 'C語言', 'C++', 'Java', 'OpenCV'),
                width=13,
                bd=3,
                command=_spin2)
spin2.grid(column=1, row=2, sticky='W')

# Using a scrolled Text control
scrolW = 30
scrolH = 5
scr = scrolledtext.ScrolledText(monty,
                                width=scrolW,
                                height=scrolH,
                                wrap=tk.WORD)
scr.grid(column=0, row=3, sticky='WE', columnspan=3)

# Add Tooltip
createToolTip(spin, '這是一個Spinbox.')
createToolTip(spin2, '這是一個Spinbox.')
createToolTip(action, '這是一個Button.')
createToolTip(nameEntered, '這是一個Entry.')
createToolTip(bookChosen, '這是一個Combobox.')
createToolTip(scr, '這是一個ScrolledText.')

# 一次性控制各控件之間的距離
for child in monty.winfo_children():
    child.grid_configure(padx=3, pady=1)
# 單獨控制個別控件之間的距離
action.grid(column=2, row=1, rowspan=2, padx=6)
#---------------Tab1控件介紹------------------#

#---------------Tab2控件介紹------------------#
# We are creating a container tab3 to hold all other widgets -- Tab2
monty2 = ttk.LabelFrame(tab2, text='控件示範區2')
monty2.grid(column=0, row=0, padx=8, pady=4)
# Creating three checkbuttons
chVarDis = tk.IntVar()
check1 = tk.Checkbutton(monty2,
                        text="失效選項",
                        variable=chVarDis,
                        state='disabled')
check1.select()
check1.grid(column=0, row=0, sticky=tk.W)

chVarUn = tk.IntVar()
check2 = tk.Checkbutton(monty2, text="遵從內心", variable=chVarUn)
check2.deselect()  #Clears (turns off) the checkbutton.
check2.grid(column=1, row=0, sticky=tk.W)

chVarEn = tk.IntVar()
check3 = tk.Checkbutton(monty2, text="屈於現實", variable=chVarEn)
check3.deselect()
check3.grid(column=2, row=0, sticky=tk.W)


# GUI Callback function
def checkCallback(*ignoredArgs):
    # only enable one checkbutton
    if chVarUn.get(): check3.configure(state='disabled')
    else: check3.configure(state='normal')
    if chVarEn.get(): check2.configure(state='disabled')
    else: check2.configure(state='normal')


# trace the state of the two checkbuttons  #？？
chVarUn.trace('w', lambda unused0, unused1, unused2: checkCallback())
chVarEn.trace('w', lambda unused0, unused1, unused2: checkCallback())

# Radiobutton list
values = ["富強民主", "文明和諧", "自由平等", "公正法治", "愛國敬業", "誠信友善"]


# Radiobutton callback function
def radCall():
    radSel = radVar.get()
    if radSel == 0: monty2.configure(text='富強民主')
    elif radSel == 1: monty2.configure(text='文明和諧')
    elif radSel == 2: monty2.configure(text='自由平等')
    elif radSel == 3: monty2.configure(text='公正法治')
    elif radSel == 4: monty2.configure(text='愛國敬業')
    elif radSel == 5: monty2.configure(text='誠信友善')


# create three Radiobuttons using one variable
radVar = tk.IntVar()

# Selecting a non-existing index value for radVar
radVar.set(99)

# Creating all three Radiobutton widgets within one loop
for col in range(4):
    #curRad = 'rad' + str(col)
    curRad = tk.Radiobutton(monty2,
                            text=values[col],
                            variable=radVar,
                            value=col,
                            command=radCall)
    curRad.grid(column=col, row=6, sticky=tk.W, columnspan=3)
for col in range(4, 6):
    #curRad = 'rad' + str(col)
    curRad = tk.Radiobutton(monty2,
                            text=values[col],
                            variable=radVar,
                            value=col,
                            command=radCall)
    curRad.grid(column=col - 4, row=7, sticky=tk.W, columnspan=3)

style = ttk.Style()
style.configure("BW.TLabel", font=("Times", "10", 'bold'))
ttk.Label(monty2, text="   社會主義核心價值觀", style="BW.TLabel").grid(column=2,
                                                               row=7,
                                                               columnspan=2,
                                                               sticky=tk.EW)

# Create a container to hold labels
labelsFrame = ttk.LabelFrame(monty2, text=' 嵌套區域 ')
labelsFrame.grid(column=0, row=8, columnspan=4)

# Place labels into the container element - vertically
ttk.Label(labelsFrame, text="你才25歲，你可以成為任何你想成為的人。").grid(column=0, row=0)
ttk.Label(labelsFrame, text="不要在乎一城一池的得失，要執著。").grid(column=0,
                                                     row=1,
                                                     sticky=tk.W)

# Add some space around each label
for child in labelsFrame.winfo_children():
    child.grid_configure(padx=8, pady=4)
#---------------Tab2控件介紹------------------#

#---------------Tab3控件介紹------------------#
tab3 = tk.Frame(tab3, bg='#AFEEEE')
tab3.pack()
for i in range(2):
    canvas = 'canvas' + str(col)
    canvas = tk.Canvas(tab3,
                       width=162,
                       height=95,
                       highlightthickness=0,
                       bg='#FFFF00')
    canvas.grid(row=i, column=i)
#---------------Tab3控件介紹------------------#


#----------------菜單欄介紹-------------------#
# Exit GUI cleanly
def _quit():
    win.quit()
    win.destroy()
    exit()


# Creating a Menu Bar
menuBar = Menu(win)
win.config(menu=menuBar)

# Add menu items
fileMenu = Menu(menuBar, tearoff=0)
fileMenu.add_command(label="新建")
fileMenu.add_separator()
fileMenu.add_command(label="退出", command=_quit)
menuBar.add_cascade(label="文件", menu=fileMenu)


# Display a Message Box
def _msgBox1():
    mBox.showinfo('Python Message Info Box', '通知：程序運行正常！')


def _msgBox2():
    mBox.showwarning('Python Message Warning Box', '警告：程序出現錯誤，請檢查！')


def _msgBox3():
    mBox.showwarning('Python Message Error Box', '錯誤：程序出現嚴重錯誤，請退出！')


def _msgBox4():
    answer = mBox.askyesno("Python Message Dual Choice Box",
                           "你喜歡這篇文章嗎？\n您的選擇是：")
    if answer == True:
        mBox.showinfo('顯示選擇結果', '您選擇了“是”，謝謝參與！')
    else:
        mBox.showinfo('顯示選擇結果', '您選擇了“否”，謝謝參與！')


# Add another Menu to the Menu Bar and an item
msgMenu = Menu(menuBar, tearoff=0)
msgMenu.add_command(label="通知 Box", command=_msgBox1)
msgMenu.add_command(label="警告 Box", command=_msgBox2)
msgMenu.add_command(label="錯誤 Box", command=_msgBox3)
msgMenu.add_separator()
msgMenu.add_command(label="判斷對話框", command=_msgBox4)
menuBar.add_cascade(label="消息框", menu=msgMenu)
#----------------菜單欄介紹-------------------#

# Change the main windows icon
# win.iconbitmap(os.path.join(os.path.abspath(os.path.curdir), 'logo.ico'))

# ====================

# Optionally, you may specify the icon sizes you want:

# Place cursor into name Entry
nameEntered.focus()
#======================
# Start GUI
#======================
win.mainloop()
