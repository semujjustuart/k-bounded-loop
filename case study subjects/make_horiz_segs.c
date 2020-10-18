static void
make_horiz_segs (GimpBoundary *boundary,
                 gint          start,
                 gint          end,
                 gint          scanline,
                 gint          empty[],
                 gint          num_empty,
                 gint          top)
{
  gint empty_index;
  gint e_s, e_e;    /* empty segment start and end values */

  for (empty_index = 0; empty_index < num_empty; empty_index += 2)
    {
      e_s = *empty++;
      e_e = *empty++;

      if (e_s <= start && e_e >= end)
        {
          process_horiz_seg (boundary,
                             start, scanline, end, scanline, top);
        }
      else if ((e_s > start && e_s < end) ||
               (e_e < end && e_e > start))
        {
          process_horiz_seg (boundary,
                             MAX (e_s, start), scanline,
                             MIN (e_e, end), scanline, top);
        }
    }
}
