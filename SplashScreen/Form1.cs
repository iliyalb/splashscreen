using System;
using System.Drawing;
using System.Windows.Forms;

namespace SplashScreen
{
    public partial class Form1 : Form
    {
        int r, g, b;
        public Form1()
        {
            
            InitializeComponent();
            r = 0;
            g = 0;
            b = 0;

            timer1.Enabled = true;
                    
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            Form2 form2 = new Form2();

            if (r < 31)
                r += 1;
            if (g < 131)
                g += 2;
            if (b < 201)
                b += 5;

            this.BackColor = Color.FromArgb(r, g, b);

            if (r >= 30 && g >= 130 && b >= 200)
            {
                this.Hide();
                form2.Closed += (s, args) => this.Close();
                timer1.Enabled = false;
                form2.Show();
            }
        }
    }
}
