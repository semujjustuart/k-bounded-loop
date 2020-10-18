static void
akima_calc (const double x_array[], double b[],  double c[],  double d[], size_t size, double m[])
{
  size_t i;

  for (i = 0; i < (size - 1); i++)
    {
      const double NE = fabs (m[i + 1] - m[i]) + fabs (m[i - 1] - m[i - 2]);
      if (NE == 0.0)
        {
          b[i] = m[i];
          c[i] = 0.0;
          d[i] = 0.0;
        }
      else
        {
          const double h_i = x_array[i + 1] - x_array[i];
          const double NE_next = fabs (m[i + 2] - m[i + 1]) + fabs (m[i] - m[i - 1]);
          const double alpha_i = fabs (m[i - 1] - m[i - 2]) / NE;
          double alpha_ip1;
          double tL_ip1;
          if (NE_next == 0.0)
            {
              tL_ip1 = m[i];
            }
          else
            {
              alpha_ip1 = fabs (m[i] - m[i - 1]) / NE_next;
              tL_ip1 = (1.0 - alpha_ip1) * m[i] + alpha_ip1 * m[i + 1];
            }
          b[i] = (1.0 - alpha_i) * m[i - 1] + alpha_i * m[i];
          c[i] = (3.0 * m[i] - 2.0 * b[i] - tL_ip1) / h_i;
          d[i] = (b[i] + tL_ip1 - 2.0 * m[i]) / (h_i * h_i);
        }
    }
}
